// RealAlumniData.java
package com.example.alumnisystem.pattern.proxy;

import com.example.alumnisystem.model.Alumni;

public class RealAlumniData implements AlumniData {
    protected Alumni alumni;

    public RealAlumniData(Alumni alumni) {
        this.alumni = alumni;
    }

    @Override
    public String getAlumniInfo() {
        return "Name: " + alumni.getName() + ", Company: " + alumni.getCompany();
    }
}
