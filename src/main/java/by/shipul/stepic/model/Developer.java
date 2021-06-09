package by.shipul.stepic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Developer implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
}
