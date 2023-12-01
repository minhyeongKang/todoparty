package com.sparta.todoparty.global.securrity.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.todoparty.global.exception.type.CustomException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j(topic = "JwtExceptionHandlerFilter")
@Component
public class JwtExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            filterChain.doFilter(request, response);
        } catch (SecurityException | MalformedJwtException | SignatureException e) {
            setErrorResponse(response, CustomException.NOT_VALID_TOKEN);
        } catch (ExpiredJwtException e) {
            setErrorResponse(response, CustomException.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            setErrorResponse(response, CustomException.UNSUPPORTED_TOKEN);
        } catch (IllegalArgumentException e) {
            setErrorResponse(response, CustomException.EMPTY_TOKEN);
        }
    }

    private void setErrorResponse(
            HttpServletResponse response,
            CustomException customException
    ) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setStatus(customException.getStatusCode());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            response.getWriter().write(objectMapper.writeValueAsString(customException.toDto()));
        } catch (IOException e) {
            logger.error(e);
        }
    }

}