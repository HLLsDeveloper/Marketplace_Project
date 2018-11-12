package br.com.crashsolutions.Acoes;

public class CalculoParcelas {
	
	public Integer parcela = 0;
	
	// CÁLCULO DO VALOR DA PARCELA
	public Float Calcular(Float valor1) {
		
		// PARCELA 2X
		if (valor1 >= 40.00 && valor1 < 60.00) {
			parcela = 2;
			valor1 = valor1/parcela;
		} else {
			// PARCELA 3X
			if (valor1 >= 60.00 && valor1 < 80.00) {
				parcela = 3;
				valor1 = valor1/parcela;
			} else {
				// PARCELA 4X
				if (valor1 >= 80.00 && valor1 < 100.00) {
					parcela = 4;
					valor1 = valor1/parcela;
				} else {
					// PARCELA 5X
					if(valor1 >= 100.00 && valor1 < 120.00) {
						parcela = 5;
						valor1 = valor1/parcela;
					} else {
						// PARCELA 6x
						if (valor1 >= 120.00 && valor1 < 140.00) {
							parcela = 6;
							valor1 = valor1/parcela;
						} else {
							// PARCELA 7x
							if (valor1 >= 140.00 && valor1 < 160.00) {
								parcela = 7;
								valor1 = valor1/parcela;
							} else {
								// PARCELA 8x
								if (valor1 >= 160.00 && valor1 < 180.00) {
									parcela = 8;
									valor1 = valor1/parcela;
								} else {
									// PARCELA 9x
									if(valor1 >= 180.00 && valor1 < 200.00) {
										parcela = 9;
										valor1 = valor1/parcela;
									} else {
										// PARCELA 10x
										if (valor1 >= 200.00) {
											parcela = 10;
											valor1 = valor1/parcela;
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
		return valor1;
	}
	
	public Integer Parcela (Float valor1) {
				
		// CÁLCULO DA PARCELA
		if (valor1 >= 40.00 && valor1 < 60.00) {
			parcela = 2;
			} else {
			if (valor1 >= 60.00 && valor1 < 80.00) {
				parcela = 3;} 
			else {
				if (valor1 >= 80.00 && valor1 < 100.00) {
					parcela = 4;} 
				else {
					if(valor1 >= 100.00 && valor1 < 120.00) {
						parcela = 5;} 
					else {
						if (valor1 >= 120.00 && valor1 < 140.00) {
							parcela = 6;} 
						else {
							if (valor1 >= 140.00 && valor1 < 160.00) {
								parcela = 7;} 
							else {
								if (valor1 >= 160.00 && valor1 < 180.00) {
									parcela = 8;} 
								else {
									if(valor1 >= 180.00 && valor1 < 200.00) {
										parcela = 9;} 
									else {
										if (valor1 >= 200.00) {
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
