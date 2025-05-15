package com.enesyalcin.DTOs;

import com.enesyalcin.entites.Department;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOEmployee {

    private Long id;

    private String name;

    private DTODepartment department;

}
