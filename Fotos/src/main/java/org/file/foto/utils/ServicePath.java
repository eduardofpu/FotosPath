package org.file.foto.utils;

public final class ServicePath {

	///////////////////////////////////////////////////////////////
	// ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";

	public static final String ROOT_PATH = "/api";

	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";

	public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";

	///////////////////////////////////////////////////////////////
	// PRIVATE PATHS
	///////////////////////////////////////////////////////////////



	public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";

	public static final String USER_PATH = PRIVATE_ROOT_PATH + "/user";

	public static final String FILE_PATH = PRIVATE_ROOT_PATH + "/file1";
	public static final String FILE2_PATH = PRIVATE_ROOT_PATH + "/file2";
	public static final String FILE3_PATH = PRIVATE_ROOT_PATH + "/file3";
	
	public static final String ARQUIVO_PATH = PRIVATE_ROOT_PATH + "/arquivo";
	public static final String LISTA_PATH = PRIVATE_ROOT_PATH + "/lista";
	
	

	///////////////////////////////////////////////////////////////
	// PUBLIC PATHS
	///////////////////////////////////////////////////////////////

	public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";

	public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";

}
