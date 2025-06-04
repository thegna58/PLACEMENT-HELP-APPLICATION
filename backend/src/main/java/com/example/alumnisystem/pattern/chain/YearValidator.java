// YearValidator.java
package com.example.alumnisystem.pattern.chain;

import com.example.alumnisystem.model.Alumni;

public class YearValidator extends AlumniHandler {
    public void handle(Alumni alumni) {
        if (alumni.getPassingYear() < 2000)
            throw new RuntimeException("Invalid Year");
        super.handle(alumni);
    }
}
