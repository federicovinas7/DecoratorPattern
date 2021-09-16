


import interfaces.BaseDatos;
import model.BaseDatosMemoria;
import model.Logger;
import model.LoggerDecorator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class TestBaseDatosConLogger {

    private Logger logger = new Logger();
    private BaseDatos sinLogger = new BaseDatosMemoria();

    private BaseDatos bbdd;

    @Before
    public void init() {


        bbdd = new LoggerDecorator(logger,sinLogger);
    }


    // de este test no hay que modificar nada
    @Test
    public void test_logger_decorator() {

        assertNotNull("falta inicializar bbdd en el metodo init()",bbdd);
        assertFalse("logger no esta vacio",logger.obtener().contains("inserta entrada"));
        bbdd.inserta("entrada");

        assertTrue("bbdd no ha recibido entrada", sinLogger.registros().contains("entrada"));
        assertTrue("no se ha registrado la entrada", logger.obtener().contains("inserta entrada"));

        // lectura con el adapter con logger
        List<String> registros = bbdd.registros();

        assertTrue("el adapter no tiene la nueva entrada", registros.contains("entrada"));

        assertTrue("no se ha registrado la lectura", logger.obtener().contains("lectura"));
    }


}
