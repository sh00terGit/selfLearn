package by.shipul.stepic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperStatus {

    private Developer developer;
    private String process;
    private String message;

}
