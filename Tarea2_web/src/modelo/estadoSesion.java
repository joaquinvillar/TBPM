package modelo;

public enum estadoSesion {
    NO_LOGIN,           // nunca intentó iniciar sesión    
    LOGIN_CORRECTO,     // tiene la sesión iniciada
    LOGIN_INCORRECTO    // intento de logueo incorrecto
}