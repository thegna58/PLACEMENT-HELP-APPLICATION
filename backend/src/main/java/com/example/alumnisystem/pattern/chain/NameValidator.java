// NameValidator.java
package com.example.alumnisystem.pattern.chain;

import com.example.alumnisystem.model.Alumni;

public class NameValidator extends AlumniHandler {
    public void handle(Alumni alumni) {
        if (alumni.getName() == null || alumni.getName().isBlank())
            throw new RuntimeException("Name is mandatory");
        super.handle(alumni);
    }
}
