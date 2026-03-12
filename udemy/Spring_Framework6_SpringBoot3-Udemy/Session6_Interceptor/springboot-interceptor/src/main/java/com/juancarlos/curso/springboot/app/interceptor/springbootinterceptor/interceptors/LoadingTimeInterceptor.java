package com.juancarlos.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Interceptor que calcula y registra el tiempo de carga de las peticiones.
 * <p>
 * Se registra el tiempo de inicio en `preHandle` y se calcula la duración en
 * `postHandle`. También se introduce una pequeña demora aleatoria para simular
 * carga y demostrar el comportamiento del interceptor.
 */

// Con la anotación @Component se indica que esta clase es un componente de
// Spring.
@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    /** Logger de la clase. */
    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: preHandle() entrando .... " + controller.getMethod().getName());

        // Registra el tiempo de inicio de la petición en el atributo "start" del
        // request
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        // Simula una pequeña demora aleatoria para medir tiempos de carga
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        // Map<String, String> json = new HashMap<>();
        // json.put("error", "no tienes acceso a esta pagina!");
        // json.put("date", new Date().toString());

        // ObjectMapper mapper = new ObjectMapper();
        // String jsonString = mapper.writeValueAsString(json);
        // response.setContentType("application/json");
        // response.setStatus(401);
        // response.getWriter().write(jsonString);
        // return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // Calcula el tiempo transcurrido desde que se guardó el atributo "start" en
        // preHandle
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        logger.info("Tiempo transcurrido: " + result + " milisegundos");

        // Registra el método del controlador que ha sido ejecutado
        logger.info("LoadingTimeInterceptor: postHandle() saliendo .... "
                + ((HandlerMethod) handler).getMethod().getName());

        // Información adicional de la respuesta (si procede)
        logger.info(response.getOutputStream().toString());
    }
}
