package modelo;

public enum estadoSesion {
    NO_LOGIN,           // nunca intent� iniciar sesi�n    
    LOGIN_CORRECTO,     // tiene la sesi�n iniciada
    LOGIN_INCORRECTO    // intento de logueo incorrecto
}