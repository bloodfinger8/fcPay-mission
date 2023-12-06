package org.fcpay.controller

import org.fcpay.service.exception.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [GlobalExceptionHandler::class])
class GlobalExceptionHandler {
    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun handleConnectionNotFoundException(e: IllegalArgumentException): ResponseEntity<BaseResponse> {
        return ResponseEntity.badRequest().body(BaseResponse(400000, e.message))
    }

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleEntityNotFoundException(e: EntityNotFoundException): ResponseEntity<BaseResponse> {
        return ResponseEntity.badRequest().body(BaseResponse(400001, e.message))
    }

    @ExceptionHandler(value = [IllegalStateException::class])
    fun handleIllegalStateException(e: IllegalStateException): ResponseEntity<BaseResponse> {
        return ResponseEntity.badRequest().body(BaseResponse(400002, e.message))
    }
}