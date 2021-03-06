package com.globalhitss.claropay.cercademi.restapi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
  value="ApiError",
  description=""
    + "It's The general error format, all application use this to throws error"
    + " messages"
)
public class ApiError 
{
  @JsonIgnore
  @ApiModelProperty(hidden=true)
  private HttpStatus status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  @ApiModelProperty(
    notes="Used to display the error's timestamp.",
    example="2019-11-26 01:34:22"
  )
  private LocalDateTime timestamp;
  @ApiModelProperty(notes="Message from manager.")
  private String message;
  @ApiModelProperty(notes="Message from debugger.")
  private String debugMessage;

  private ApiError() {
    timestamp = LocalDateTime.now();
  }

  ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  ApiError(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.message = "Unexpected error";
    this.debugMessage = ex.getLocalizedMessage();
  }

  ApiError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }
  
  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDebugMessage() {
    return debugMessage;
  }

  public void setDebugMessage(String debugMessage) {
    this.debugMessage = debugMessage;
  }
}