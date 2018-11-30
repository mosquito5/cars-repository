package pl.mosquito.cars.security;

import java.security.SecureRandom;

public class PassGen {
    private final int PASSLEN = 10;
    private final String VALUES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private StringBuilder pass = new StringBuilder(PASSLEN);

    public PassGen() {
        gen();
    }

    private void gen() {
        SecureRandom rnd = new SecureRandom();

        for(int i = 0; i < PASSLEN; i++) {
            pass.append(VALUES.charAt(rnd.nextInt(VALUES.length())));
        }
    }

    public String getPass(){
        return pass.toString();
    }
}
