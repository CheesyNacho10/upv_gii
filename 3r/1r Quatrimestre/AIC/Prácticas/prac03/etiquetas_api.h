 void te_inserta ( 
	char *texto,
	dword direccion,
	modo_t tipo_memoria
	 );
 word te_resuelve ( 
	char *texto,
	word linea,
	dword puntero,
	modo_t tipo_memoria
	 );
 void te_confirma (void);
 void te_etiqueta ( 
	char *texto,
	dword direccion,
	modo_t tipo_memoria
	 );
 int te_busca ( 
	dword direccion,
	modo_t tipo_memoria
	 );
 void te_borra (void);
