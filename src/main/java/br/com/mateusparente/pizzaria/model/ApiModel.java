package br.com.mateusparente.pizzaria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
public class ApiModel {

}