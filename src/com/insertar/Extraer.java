package com.insertar;

public class Extraer {

		private int pais;
		private int canal;
		private int sucursal;
		private int folio;
		private String clob;
		private int estatus;
		private String registro;
		private String ultima;
		private String user;
	
		public Extraer(int pais, int canal, int sucursal, int folio, String clob, int estatus, String registro,
				String ultima, String user) {
			super();
			this.pais = pais;
			this.canal = canal;
			this.sucursal = sucursal;
			this.folio = folio;
			this.clob = clob;
			this.estatus = estatus;
			this.registro = registro;
			this.ultima = ultima;
			this.user = user;
		}

		@Override
		public String toString() {
			return "Extraer [pais=" + pais + ", canal=" + canal + ", sucursal=" + sucursal + ", folio=" + folio
					+ ", clob=" + clob + ", estatus=" + estatus + ", registro=" + registro + ", ultima=" + ultima
					+ ", user=" + user + "]";
		}

		public int getPais() {
			return pais;
		}

		public void setPais(int pais) {
			this.pais = pais;
		}

		public int getCanal() {
			return canal;
		}

		public void setCanal(int canal) {
			this.canal = canal;
		}

		public int getSucursal() {
			return sucursal;
		}

		public void setSucursal(int sucursal) {
			this.sucursal = sucursal;
		}

		public int getFolio() {
			return folio;
		}

		public void setFolio(int folio) {
			this.folio = folio;
		}

		public String getClob() {
			return clob;
		}

		public void setClob(String clob) {
			this.clob = clob;
		}

		public int getEstatus() {
			return estatus;
		}

		public void setEstatus(int estatus) {
			this.estatus = estatus;
		}

		public String getRegistro() {
			return registro;
		}

		public void setRegistro(String registro) {
			this.registro = registro;
		}

		public String getUltima() {
			return ultima;
		}

		public void setUltima(String ultima) {
			this.ultima = ultima;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}
	
		
		
}
