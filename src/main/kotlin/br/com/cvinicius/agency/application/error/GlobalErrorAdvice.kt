import org.springframework.boot.autoconfigure.web.WebProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

//@Component
//@Order(-2)
class GlobalError(errorAttributes: ErrorAttributes?,
                  resources: WebProperties.Resources?,
                  applicationContext: ApplicationContext?) : AbstractErrorWebExceptionHandler(errorAttributes, resources, applicationContext) {

    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
    }

    private fun formatErrorResponse(request: ServerRequest): Mono<ServerResponse> {

        val errorAttributesMap = getErrorAttributes(request, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE))

        return ServerResponse.status(HttpStatus.BAD_REQUEST)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(errorAttributesMap))
    }
}