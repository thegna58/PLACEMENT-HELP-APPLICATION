// AnonymousAlumniProxy.java
package com.example.alumnisystem.pattern.proxy;

import com.example.alumnisystem.model.Alumni;

public class AnonymousAlumniProxy implements AlumniData {
    private final RealAlumniData realAlumniData;

    public AnonymousAlumniProxy(Alumni alumni) {
        this.realAlumniData = new RealAlumniData(alumni);
    }

    @Override
    public String getAlumniInfo() {
        if (realAlumniData.alumni.getAnonymous()) {
            return "Anonymous Alumni";
        }
        return realAlumniData.getAlumniInfo();
    }
}
