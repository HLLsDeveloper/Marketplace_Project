package br.com.crashsolutions.Acoes;

public class CalculoParcelas {
	
	public Integer parcela = 0;
	
	// CÁLCULO DO VALOR DA PARCELA
	public Float Calcular(Float valor) {
		
		// PARCELA 2X
		if (valor >= 40.00 && valor < 60.00) {
			parcela = 2;
			valor = valor/parcela;
		} else {
			// PARCELA 3X
			if (valor >= 60.00 && valor < 80.00) {
				parcela = 3;
				valor = valor/parcela;
			} else {
				// PARCELA 4X
				if (valor >= 80.00 && valor < 100.00) {
					parcela = 4;
					valor = valor/parcela;
				} else {
					// PARCELA 5X
					if(valor >= 100.00 && valor < 120.00) {
						parcela = 5;
						valor = valor/parcela;
					} else {
						// PARCELA 6x
						if (valor >= 120.00 && valor < 140.00) {
							parcela = 6;
							valor = valor/parcela;
						} else {
							// PARCELA 7x
							if (valor >= 140.00 && valor < 160.00) {
								parcela = 7;
								valor = valor/parcela;
							} else {
								// PARCELA 8x
								if (valor >= 160.00 && valor < 180.00) {
									parcela = 8;
									valor = valor/parcela;
								} else {
									// PARCELA 9x
									if(valor >= 180.00 && valor < 200.00) {
										parcela = 9;
										valor = valor/parcela;
									} else {
										// PARCELA 10x
										if (valor >= 200.00) {
											parcela = 10;
											valor = valor/parcela;
										} else {
											parcela = 1;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return valor;
	}
	
	public Integer Parcela (Float valor) {
				
		// CÁLCULO DA PARCELA
		if (valor >= 40.00 && valor < 60.00) {
			parcela = 2;
			} else {
			if (valor >= 60.00 && valor < 80.00) {
				parcela = 3;} 
			else {
				if (valor >= 80.00 && valor < 100.00) {
					parcela = 4;} 
				else {
					if(valor >= 100.00 && valor < 120.00) {
						parcela = 5;} 
					else {
						if (valor >= 120.00 && valor < 140.00) {
							parcela = 6;} 
						else {
							if (valor >= 140.00 && valor < 160.00) {
								parcela = 7;} 
							else {
								if (valor >= 160.00 && valor < 180.00) {
									parcela = 8;} 
								else {
									if(valor >= 180.00 && valor < 200.00) {
										parcela = 9;} 
									else {
										if (valor >= 200.00) {
											parcela = 10;} 
										else {
											parcela = 1;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return parcela;
	}
}
