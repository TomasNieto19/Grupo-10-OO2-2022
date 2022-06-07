package com.Grupo10OO22022.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	// HOME
	public final static String INDEX = "home/index";
	public final static String ABOUT = "home/about";

	// PERFIL
	public final static String PERFIL_INDEX = "perfil/index";

	// USUARIO
	public final static String USUARIO_INDEX = "usuario/index";

	// USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";

	// ADMIN
	public final static String ADMIN_INDEX = "admin/index";

	// ESPACIO
	public final static String ESPACIO_CREAR_ESPACIO = "espacio/crearEspacios";
	public final static String ESPACIO_VER_ESPACIO = "espacio/verEspacios";

	// NOTAS PEDIDOS

	// -VER
	public final static String NOTA_PEDIDO_CURSADAS = "notaPedido/cursadas";
	public final static String NOTA_PEDIDO_FINALES = "notaPedido/finales";
	// -DETALLES
	public final static String NOTA_PEDIDO_DETALLE_CURSADA = "notaPedido/detalle_cursada";
	public final static String NOTA_PEDIDO_DETALLE_FINAL = "notaPedido/detalle_final";
	// -CREAR
	public final static String NOTA_PEDIDO_FORM_CURSADA = "notaPedido/form_cursada";
	public final static String NOTA_PEDIDO_FORM_FINAL = "notaPedido/form_final";

	// FINAL
	public final static String FINAL_VER_FORM = "finales/form_final";

	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String DEGREE_ROOT = "/degrees/";
	public final static String PERSON_ROOT = "/person";

}