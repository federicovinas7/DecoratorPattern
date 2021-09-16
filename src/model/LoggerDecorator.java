package model;

import interfaces.BaseDatos;

import java.util.List;

public class LoggerDecorator implements BaseDatos {

	private Logger logger;
	private BaseDatos bd;

	public LoggerDecorator(Logger logger, BaseDatos bd) {
		this.logger = logger;
		this.bd = bd;
	}

	@Override
	public void inserta(String registro) {
		this.logger.add("inserta");
		this.bd.inserta(registro);
	}

	@Override
	public List<String> registros() {
		this.logger.add("lectura");
		return this.bd.registros();

	}

	

}
