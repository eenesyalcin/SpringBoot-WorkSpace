package com.enesyalcin.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOStudentIU {

    // @NotNull     --> Değer null olarak girildiyse.(değer=null;)
    // @NotEmpty    --> Değer olarak tırnak içinde boş değer gönderirsek(değer="";)
    // @NotBlank    --> Değer girilmeden sadece değişken varsa blank(değer;)
    // @Min         --> Sayısal değerler için minimum değer kontrolü
    // @Max         --> Sayısal değerler için maximum değer kontrolü
    // @Size        --> Sayısal olmayan değerler için hem minimum, hem de maximum değer kontrolü
    // @Email       --> Email format kontrolü
    // @Valid       --> Controller sınıfında validasyonların tanınması için tanımlanması gereken anatasyon

    @NotEmpty(message = "İsim alanı boş geçilemez!")
    @Size(min = 3, max = 10, message = "İsim alanı en az 3 ve en fazla 10 karakter olmalıdır!")
    private String firstName;

    @Size(min = 3, max = 15, message = "Soyisim alanı en az 3 ve en fazla 15 karakter olamaldır!")
    private String lastName;

    private Date birthOfDate;
}
