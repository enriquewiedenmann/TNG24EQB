package persistencia;

import java.util.ArrayList;


public abstract class AdministradorPersistencia 
{
	public abstract int insert (Object o);
	public abstract void update (Object o);
	public abstract void delete (Object d);
	public abstract ArrayList<Object> select ();
	
}
