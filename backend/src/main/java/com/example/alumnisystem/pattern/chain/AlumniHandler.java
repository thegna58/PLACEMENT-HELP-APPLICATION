// AlumniHandler.java
package com.example.alumnisystem.pattern.chain;

import com.example.alumnisystem.model.Alumni;

public abstract class AlumniHandler {
    protected AlumniHandler next;

    public void setNext(AlumniHandler next) {
        this.next = next;
    }

    public void handle(Alumni alumni) {
        if (next != null) next.handle(alumni);
    }
}
