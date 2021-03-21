package com.example.demo.dto.CommentDTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCommentDTO {
    @NotBlank(message = "El text es requerido")
    @Size(max=255, message = "La longitud máxima es de 255 caracteres")
    public String text;
    @Min(0)
    @Max(10)
    public Integer rating;
    
}
