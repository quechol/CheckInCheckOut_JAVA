
import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/*    ------------   MAIN   ----------     */
public class User {
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		CrearDirectorios crea = new CrearDirectorios();
		@SuppressWarnings("unused")
		busquedaUsuarioRegistro inicio = new busquedaUsuarioRegistro("","");
		
		MenuInicial pantalla = new MenuInicial();
		pantalla.setSize(400,600);
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);
		pantalla.setLocationRelativeTo(null);
		@SuppressWarnings("unused")
		registraFecha fecha = new registraFecha();
	}
}

/*    ------------   MENU INICIAL   ----------     */

@SuppressWarnings("serial")
class MenuInicial extends JFrame implements ActionListener{
	registraFecha fecha = new registraFecha();
	Interfaz pantalla2;
	JButton entrada = new JButton("ENTRADA");
	JButton salida = new JButton("SALIDA");
	JButton registrar = new JButton("REGISTRAR");
	JButton salir = new JButton("SALIR");
	JButton resumen = new JButton("RESUMEN");
	//Botones de inicio
	JPanel contenedor;
	JPanel contenedor2;
	JPanel contenedor3;
	//Contenedores
	public MenuInicial(){
		pantalla2 = new Interfaz();
		entrada.addActionListener(this);
		salida.addActionListener(this);
		registrar.addActionListener(this);
		salir.addActionListener(this);	    
		resumen.addActionListener(this);	
		this.setTitle("BIENVENIDO");		        
		contenedor = new JPanel();			
		contenedor.setLayout(null);			
		contenedor2 = new JPanel();
		contenedor2.setLayout(new BoxLayout(contenedor2,BoxLayout.Y_AXIS));
		contenedor.add(entrada);
		contenedor.add(salida);
		contenedor.add(registrar);
		contenedor.add(salir);
		contenedor.add(resumen);
		contenedor2.add(contenedor);
		entrada.setBounds(125,190,120,25);
		salida.setBounds(125,250,120,25);
		registrar.setBounds(125,310,120,25);
		salir.setBounds(250,500,100,25);
		resumen.setBounds(50,500,100,25);
		getContentPane().add(contenedor);
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==entrada){
			pantalla2.setSize(400,600);
			pantalla2.setResizable(false);
			pantalla2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pantalla2.registrar.setVisible(false);
			pantalla2.registrarSalida.setVisible(false);
			pantalla2.setVisible(true);
			pantalla2.setLocationRelativeTo(null);
			this.setVisible(false);
		}else {
			if (e.getSource()==salida){
				pantalla2.setSize(400,600);
				pantalla2.setResizable(false);
				pantalla2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pantalla2.registrar.setVisible(false);
				pantalla2.registrarEntrada.setVisible(false);
				pantalla2.setVisible(true);
				pantalla2.setLocationRelativeTo(null);
				this.setVisible(false);
			}else {
				if (e.getSource()==registrar){
					Registro regis = new Registro();
					regis.setSize(400,600);
					regis.setResizable(false);
					regis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					regis.setVisible(true);
					regis.setLocationRelativeTo(null);
					this.setVisible(false);
				}else{
					if(e.getSource()==salir){
						JOptionPane.showMessageDialog(null, "Que tenga un buen dia.");
						System.exit(0);
					}else {
						if(e.getSource()==resumen) {
							Resumen resumen = new Resumen();
							resumen.setSize(400,280);
							resumen.setResizable(false);
							resumen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							resumen.setVisible(true);
							resumen.setLocationRelativeTo(null);
							this.setVisible(false);
						}
					}
				}
			}	
		}
	}
}

/*    ------------   INTERFAZ   ----------     */
@SuppressWarnings("serial")
class Interfaz extends JFrame implements ActionListener{
    boolean re,lo;
	int rE,rS;
    String Nusuario;
    String Ncontrasena;
	JButton entrada = new JButton("ENTRADA");
    JButton salida = new JButton("SALIDA");
    JButton salir = new JButton("SALIR");
    JButton resumen = new JButton("RESUMEN");
    JButton atras = new JButton("ATRAS");
    JButton registrar = new JButton("REGISTRAR"); 
    JButton registrarEntrada = new JButton("ACEPTAR");
    JButton registrarSalida = new JButton("ACEPTAR");
    JTextField usuario = new JTextField();
    JPanel contenedor;
    JPanel contenedor2;
    JPanel contenedor3;
    public Interfaz (){
    	entrada.addActionListener(this);
    	salida.addActionListener(this);
    	registrarEntrada.addActionListener(this);
    	registrarSalida.addActionListener(this);
    	registrar.addActionListener(this);
    	salir.addActionListener(this);
    	resumen.addActionListener(this);
        atras.addActionListener(this);
        usuario.addActionListener(this);
        contenedor = new JPanel();			
        contenedor.setLayout(null);			
        contenedor2 = new JPanel();
        contenedor2.setLayout(new BoxLayout(contenedor2,BoxLayout.Y_AXIS));
        contenedor.add(registrar);
        contenedor.add(salir);
        contenedor.add(atras);
        contenedor.add(registrarEntrada);
        contenedor.add(registrarSalida);
        contenedor.add(usuario);
        contenedor2.add(contenedor);
        atras.setBounds(200,500,90,21);
        salir.setBounds(300,500,90,21);
        registrar.setBounds(125,300,150,25);
        registrarEntrada.setBounds(125,300,150,25);
        registrarSalida.setBounds(125,300,150,25);
        usuario.setBounds(125,190,150,25);
        getContentPane().add(contenedor);
        repaint();
    }
    
    @SuppressWarnings("unused")
	@Override
    public void actionPerformed(ActionEvent e){
        		if(e.getSource()==registrarEntrada){
        			Nusuario = usuario.getText();
        			if( Nusuario.length()==0){
        				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos ó ingrese datos validos.");
        				limpiarCampos();
        			}else {
        				busquedaUsuario comprueba = new busquedaUsuario(Nusuario);
        				if (comprueba.flag==0){
        					JOptionPane.showMessageDialog(null, "Usuario no existe en la BD");
        					limpiarCampos();
        				}else {
        					String fecha=java.time.LocalDate.now().toString();
        					String movimiento ="ENTRADA";
        					String nombre =Nusuario;
        					String clave = comprueba.clavePos;
        					String nomP = comprueba.nombreUser;
        					verificaMovimiento entra = new verificaMovimiento(clave,fecha,movimiento,nombre);
        					rE = entra.flag; 
        					if (rE==0) {	
        						JOptionPane.showMessageDialog(null, " Ya se tiene registro de su entrada.");
        						limpiarCampos();
        					}else{
        						registroMovimiento entraNuevo = new registroMovimiento(nombre, movimiento,clave);
        						JOptionPane.showMessageDialog(null, "Se ha registrado su entrada satisfactoriamente. \n Que tenga un buen dia");
        						limpiarCampos();
        					}
        				}
        				limpiarCampos();
        			}
        		}else{
        			if(e.getSource()==registrarSalida){
        				Nusuario = usuario.getText();
        				if( Nusuario.length()==0){
        					JOptionPane.showMessageDialog(null, "Por favor llene todos los campos ó ingrese datos validos.");
        					limpiarCampos();
        				}else{
        					busquedaUsuario comprueba = new busquedaUsuario(Nusuario);
        					if (comprueba.flag==0){
        						JOptionPane.showMessageDialog(null, "Usuario no existe en la BD");
        						limpiarCampos();
        					}else {
            					String fecha=java.time.LocalDate.now().toString();
            					String movimiento ="SALIDA";
            					String nombre =Nusuario;
            					String clave = comprueba.clavePos;
            					String nomP = comprueba.nombreUser;
            					verificaMovimiento entra = new verificaMovimiento(clave,fecha,movimiento,nombre);
            					rE = entra.flag; 
            					if (rE==0) {	
            						JOptionPane.showMessageDialog(null, " Ya se tiene registro de su salida.");
            						limpiarCampos();
            					}else{
            						registroMovimiento saleNuevo = new registroMovimiento(nombre, movimiento,clave);
            						JOptionPane.showMessageDialog(null, "Se ha registrado su salida satisfactoriamente. \n Que tenga un buen dia");
            						limpiarCampos();
            					}
        					}
        					limpiarCampos();
        				}
        			}else {
        				if(e.getSource()==salir){
        					JOptionPane.showMessageDialog(null, "Que tenga un buen dia.");
        					System.exit(0);
        				}else{
        					if(e.getSource()==atras){
        						limpiarCampos();
        						MenuInicial pantalla = new MenuInicial();
        						pantalla.setSize(400,600);
        						pantalla.setResizable(false);
        						pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        						pantalla.setVisible(true);
        						pantalla.setLocationRelativeTo(null);
        						this.setVisible(false);
        					}
        				}
        			}
        		}
    	}
    
    public void limpiarCampos(){
    	  usuario.setText("");
    }
}

/*    ------------   REGISTRO   ----------     */
@SuppressWarnings("serial")
class Registro extends JFrame implements ActionListener{
	String clave1="BC",clave2="CA",clave3="CB";
	String Nusuario="";
	String claveSel="";
	boolean re = false;
	JButton registrar = new JButton("REGISTRAR");    
    JButton salir = new JButton("SALIR");
    JButton atras = new JButton("ATRAS");
    JTextField usuario = new JTextField();
    @SuppressWarnings("rawtypes")
	JComboBox claves = new JComboBox();
    JLabel textoNombre = new JLabel("Nombre :");
    JLabel textoClave = new JLabel("Clave :");
    JPanel contenedor;
    JPanel contenedor2;
    JPanel contenedor3;
	@SuppressWarnings("unchecked")
	public Registro() {
		registrar.addActionListener(this);
    	salir.addActionListener(this);
        atras.addActionListener(this);
        usuario.addActionListener(this);
        claves.addItem(clave1);
        claves.addItem(clave2);
        claves.addItem(clave3);
        claves.addActionListener(this);
        contenedor = new JPanel();			
	    contenedor.setLayout(null);			
	    contenedor2 = new JPanel();
	    contenedor2.setLayout(new BoxLayout(contenedor2,BoxLayout.PAGE_AXIS));
        contenedor.add(registrar);
        contenedor.add(salir);
        contenedor.add(atras);
        contenedor.add(usuario);
        contenedor.add(claves);
        contenedor.add(textoClave);
        contenedor.add(textoNombre);
        contenedor2.add(contenedor);
        atras.setBounds(200,500,90,21);
        salir.setBounds(300,500,90,21);
        registrar.setBounds(170,300,150,25);
        claves.setBounds(125,230,150,25);
        usuario.setBounds(125,190,150,25);
        textoNombre.setBounds(70,180,100,40);
        textoClave.setBounds(84,220,100,40);
        getContentPane().add(contenedor);
        repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==registrar){
				Nusuario = usuario.getText();
	            if( Nusuario.length()==0){
	              JOptionPane.showMessageDialog(null, "Por favor llene los campos ó ingrese datos validos.");
	              limpiarCampos();
	            }else {
	            	claveSel = claves.getSelectedItem().toString();
	            	re  = registrarse(Nusuario,claveSel);
	            	limpiarCampos();
	            }
		}else {
			if(e.getSource()==salir){
				JOptionPane.showMessageDialog(null, "Que tenga un buen dia.");
				System.exit(0);
			}else{
				if(e.getSource()==atras){
					limpiarCampos();
					MenuInicial pantalla = new MenuInicial();
					pantalla.setSize(400,600);
					pantalla.setResizable(false);
					pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					pantalla.setVisible(true);
					pantalla.setLocationRelativeTo(null);
					this.setVisible(false);
				}
			}
		}
	}
	public void limpiarCampos(){
  	  usuario.setText("");
	}
	
	@SuppressWarnings("unused")
	public boolean registrarse(String userName, String clave) {
    	String Id="";
    	busquedaUsuarioRegistro buscar = new busquedaUsuarioRegistro(userName,clave);
    	int res=0;
    	res= buscar.flag;
    	if (res == 0 ) {
    		creacionID id = new creacionID(userName,clave);
    		Id =  id.ID;	
    		registroBD reg = new registroBD(userName, Id,clave);
    		JOptionPane.showMessageDialog(null, "Exito al registrar usaurio :"+userName+"\n Su ID autogenerada es: "+Id+"\n Que tenga un buen dia.");
    		return(true);
    	}else{
    		JOptionPane.showMessageDialog(null, "Usuario con Atributo ya existente en base de datos, intente con otro nombre u otro atributo");
    		return(false);
    	}	
    }
}

/*    ------------   RESUMEN   ----------     */
@SuppressWarnings("serial")
class Resumen extends JFrame implements ActionListener{
	String clave1="BC",clave2="CA",clave3="CB",clave4="TODOS";
	JPanel contenedor;
    JPanel contenedor2;
	JButton salir = new JButton("SALIR");
	JButton atras = new JButton("ATRAS");
	JButton aceptar = new JButton("ACEPTAR");
	@SuppressWarnings("rawtypes")
	JComboBox fechas = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox claves = new JComboBox();
	JLabel textoFecha = new JLabel("FECHA :");
	JLabel textoClave = new JLabel("CLAVE :");
	@SuppressWarnings("unchecked")
	public Resumen() {
		fechas listFechas = new fechas();
		int size=listFechas.listaFechas.size();
		for (int i=0; i < size; i++) {
			fechas.addItem(listFechas.listaFechas.get(i));
		}
		claves.addItem(clave4);
		claves.addItem(clave1);
		claves.addItem(clave2);
		claves.addItem(clave3);
		salir.addActionListener(this);
	    atras.addActionListener(this);
	    aceptar.addActionListener(this);
	    fechas.addActionListener(this);
	    claves.addActionListener(this);
	    contenedor = new JPanel();			
	    contenedor.setLayout(null);			
	    contenedor2 = new JPanel();
	    contenedor2.setLayout(new BoxLayout(contenedor2,BoxLayout.PAGE_AXIS));
	    contenedor.add(salir);
	    contenedor.add(atras);
	    contenedor.add(aceptar);
	    contenedor.add(fechas);
	    contenedor.add(claves);
	    contenedor.add(textoFecha);
	    contenedor.add(textoClave);
	    textoFecha.setBounds(20,80,80,21);
	    textoClave.setBounds(20,40,80,21);
	    aceptar.setBounds(280,110,90,21);
	    claves.setBounds(100,40,150,21);
	    fechas.setBounds(100,80,150,21);
	    atras.setBounds(50,200,90,21);
	    salir.setBounds(150,200,90,21);
	    getContentPane().add(contenedor);	
	    repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==salir){					
			JOptionPane.showMessageDialog(null, "Que tenga un buen dia.");
			System.exit(0);
		}else{
			if(e.getSource()==atras){
				MenuInicial pantalla = new MenuInicial();
				pantalla.setSize(400,600);
				pantalla.setResizable(false);
				pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				this.setVisible(false);
			}else {
				if(e.getSource()==aceptar) {
					String fechaSeleccionada="";
					String claveSeleccionada="";
		    		fechaSeleccionada = fechas.getSelectedItem().toString();
		    		claveSeleccionada = claves.getSelectedItem().toString();
					muestraResumen show = new muestraResumen(fechaSeleccionada,claveSeleccionada);
					show.setSize(400,600);
					show.setResizable(false);
					show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					show.setLocationRelativeTo(null);
					show.setVisible(true);
					this.setVisible(false);
				}
			}
		}
	}
}

/*    ------------   MUESTRARESUMEN   ----------     */
@SuppressWarnings("serial")
class muestraResumen extends JFrame implements ActionListener{
	String fechasSelecionada="",clavesSeleccionada="";
	JTextArea campotexto;
	JScrollPane jsp;
	JButton salir = new JButton("SALIR");
	JButton atras = new JButton("INICIO");
	JButton aceptar = new JButton("ACEPTAR");
	public muestraResumen (String fechaSeleccionada,String claveSeleccionada) {
		fechasSelecionada=fechaSeleccionada;
		clavesSeleccionada=claveSeleccionada;
		campotexto = new JTextArea(30,33);
		jsp = new JScrollPane(campotexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setLayout(new FlowLayout());
		add(jsp);
		add(salir);
		add(atras);
		add(aceptar);
		salir.addActionListener(this);
	    atras.addActionListener(this);
	    aceptar.addActionListener(this);
	    atras.setBounds(50,530,64,21);
	    salir.setBounds(120,530,64,21);
	    aceptar.setBounds(200,530,64,21);
	    campotexto.append("Fecha seleccionada: "+fechaSeleccionada+" \n");
	    campotexto.append("Clave seleccionada: "+claveSeleccionada+" \n\n");
	    mostrarRegistro m = new mostrarRegistro(fechaSeleccionada,claveSeleccionada);
	    campotexto.append(m.cadena);	    
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==salir){					
			JOptionPane.showMessageDialog(null, "Que tenga un buen dia.");
			System.exit(0);
		}else{
			if(e.getSource()==atras){
				MenuInicial pantalla = new MenuInicial();
				pantalla.setSize(400,600);
				pantalla.setResizable(false);
				pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				this.setVisible(false);
			}else {
				if(e.getSource()==aceptar){
					String impresion="";
					impresion=campotexto.getText();
					ImprimeFinal imp = new ImprimeFinal(impresion,fechasSelecionada,clavesSeleccionada);
					Resumen resumen = new Resumen();
					resumen.setSize(400,280);
					resumen.setResizable(false);
					resumen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					resumen.setVisible(true);
					resumen.setLocationRelativeTo(null);
					this.setVisible(false);
				}
			}
		}
	}
	
}

/*    ------------   CLASES   ----------     */

class registroBD{
	String cadena="",nombreLog="",ruta="";
	@SuppressWarnings("unused")
	public registroBD(String nombre, String ID, String clave) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		cadena = nombre+","+ID+","+clave;
		nombreLog = ID+"_log.txt";
		ruta = "c:/Registro/archivos/";
		try {
			File file = new File("c:/Registro/archivos/BD.txt");
			creaCarpeta cCarpeta = new creaCarpeta(ID,clave,nombre);
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(cadena);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			    if (bw != null)
			        bw.close();
			    if (fw != null)
			        fw.close();
			} catch (IOException ex) {
			    ex.printStackTrace();
			}
		}
	}
}

class creacionID{
	String ID ="";
	public creacionID(String nombre, String clave) {
		String anio ="",fecha,nom2="",claveF="";
		String clave1="BC",clave2="CA",clave3="CB";
		fecha =java.time.LocalDate.now().toString();
		for (int i=2;i<4;i++) {
			anio = anio+fecha.charAt(i);
		}
		for (int j=0; j<2;j++) {
			nom2=nom2+nombre.charAt(j);
		}
		int con=0;
		int lengde = nombre.length();
		for(int i=0; i<lengde;i++) { 
		      if(Character.isUpperCase(nombre.charAt(i))){ 
		    	  con++;
		    	  if(con == 2) {
		    		nom2=nom2+nombre.charAt(i); 
		    	  }
		      }
		}
		String MA = "";
		char Caracter;
		Random rnd = new Random();
		for ( int i = 0; i < 2; i++)
		{
		 	int x= (int)(rnd.nextDouble() *9 + 48);
		 	Caracter = (char)(x);
			MA += Caracter;
		}
		if(clave.contains(clave1)) {
			claveF ="BC";
		}else if(clave.contains(clave2)) {
			claveF ="CA";
		}else if(clave.contains(clave3)) {
			claveF ="CB";
		}
		ID = anio+claveF+MA+nom2;	
	}
}

class busquedaUsuarioRegistro{
	String[] parts;
	String nombreUser;
	String claveUser;
	String cadena ="";
	String clavePos ="";
	int flag;	
	public busquedaUsuarioRegistro(String cadena, String clave) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		boolean contiene = false;
		try {
		    archivo = new File ("c:/Registro/archivos/BD.txt");
		    fr = new FileReader (archivo);
		    br = new BufferedReader(fr);
		    if (!archivo.exists()) {
				 archivo.createNewFile();
			 }
		    String linea;
		   	while((linea=br.readLine())!=null){
	        	if (linea.contains(cadena)) {   
	        		if(linea.contains(clave)) {
                    	contiene = true;
	        			String[]parts = linea.split(",");
	        			nombreUser = parts[0];
	        			claveUser = parts[1];
	        			clavePos = parts[2];
	        		}
                }
		    }
		    if(!contiene){ 
				flag =0;
            }else{
            	flag=1;
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
	}
}

class busquedaUsuario{
		String[] parts;
		String nombreUser;
		String claveUser;
		String cadena ="";
		String clavePos ="";
		int flag;	
		public busquedaUsuario(String cadena) {
			File archivo = null;
			FileReader fr = null;
			BufferedReader br = null;
			boolean contiene = false;
			try {
			    archivo = new File ("c:/Registro/archivos/BD.txt");
			    fr = new FileReader (archivo);
			    br = new BufferedReader(fr);
			    String linea;
			   	while((linea=br.readLine())!=null){
		        	if (linea.contains(cadena)) {   
	                    	contiene = true;
		        			String[]parts = linea.split(",");
		        			nombreUser = parts[0];
		        			claveUser = parts[1];
		        			clavePos = parts[2];
	                }
			    }
			    if(!contiene){ 
					flag =0;
	            }else{
	            	flag=1;
	            }
			}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				try{                    
					if( null != fr ){   
						fr.close();     
					}                  
				}catch (Exception e2){ 
					e2.printStackTrace();
				}
			}
		}
}

class registroMovimiento{
	public registroMovimiento(String ID, String tipoMovimiento,String clave) {
		String ruta="c:/Registro/archivos/"+clave+"/"+ID;
		String ruta2="c:/Registro/archivos/ALL/"+ID;
		String fecha = java.time.LocalDate.now().toString();
		String hora = java.time.LocalTime.now().toString();
		String nArchivo=fecha+".txt";
		try {
			 File file = new File(ruta,nArchivo);
			 File file2 = new File(ruta2,nArchivo);
			 FileWriter fw = new FileWriter(file,true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(fecha+","+hora+","+tipoMovimiento);
             bw.newLine();
             bw.close();
             FileWriter fw2 = new FileWriter(file2,true);
             BufferedWriter bw2 = new BufferedWriter(fw2);
             bw2.write(fecha+","+hora+","+tipoMovimiento);
             bw2.newLine();
             bw2.close();
		} catch (IOException e) {
            e.printStackTrace();     
        }
	
	}
}

class verificaMovimiento{
	int flag=0;
	public verificaMovimiento(String clave, String fecha, String movimiento, String id) {
		String ruta="c:/Registro/archivos/"+clave+"/"+id+"/"+fecha+".txt";
		try {
			File verificar = new File(ruta);
			FileReader fr = null;
			BufferedReader br= null;
			if (!verificar.exists()) {
				verificar.createNewFile();
				flag=1;
			}else {
				fr = new FileReader (verificar);
			    br = new BufferedReader(fr);
				String linea;
			   	while((linea=br.readLine())!=null){
		        	if (linea.contains(movimiento)) {   
	                    flag=0;
		        	}else {
		        		flag=1;
		        	}
			   }
			}
		}catch (IOException e) {
            e.printStackTrace();     
        }
	}
}

class registraFecha {
	boolean contiene = false;
	@SuppressWarnings("unused")
	public registraFecha() {
		String ruta="c:/Registro/archivos/";
		String nom="fechas.txt";
		String fecha = java.time.LocalDate.now().toString();
		String hora = java.time.LocalTime.now().toString();
		int resp=1;
		try {
			 File file2 = new File(ruta,nom);
			 FileWriter fw = new FileWriter(file2,true);
			 FileReader fr = null;
			 BufferedReader br = null;
			 if (!file2.exists()) {
				 file2.createNewFile();
			 }
			    fr = new FileReader (file2);
			    br = new BufferedReader(fr);
			    String linea;
			   	while((linea=br.readLine())!=null){
		        	if (linea.contains(fecha)) {   
	                    contiene = true;
		        	}else {
		        	}
			   }
			   	if(contiene == false) {
			   		BufferedWriter bw = new BufferedWriter(fw);
        			bw.write(fecha);
        			bw.newLine();
        			bw.close();
			   	}
			   	fr.close();
			   	br.close();
		} catch (IOException e) {
            e.printStackTrace();     
        }
		
	}
}

class fechas{
	ArrayList<String> listaFechas = new ArrayList<String>();
	fechas(){
		String ruta="c:/Registro/archivos/";
		String nom="fechas.txt";
		try {
			File file2 = new File(ruta,nom);
			FileReader fr = null;
			BufferedReader br = null;
			fr = new FileReader (file2);
		    br = new BufferedReader(fr);
		    String linea;
		    while((linea=br.readLine())!=null){
		    	listaFechas.add(linea);
		    }
		    br.close();
		    fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class mostrarRegistro{
	String cadena="";
	public mostrarRegistro(String fecha, String clave) {
		String clave1="BC", clave2="CA", clave3="CB", clave4="TODOS";
		if(clave.equals(clave1)) {
			mostrarBC muestra = new mostrarBC(fecha);
			cadena = muestra.cadena;
		}else if(clave.equals(clave2)) {
			mostrarCA muestra = new mostrarCA(fecha);
			cadena = muestra.cadena;
		}else if(clave.equals(clave3)) {
			mostrarCB muestra = new mostrarCB(fecha);
			cadena = muestra.cadena;
		}else if(clave.equals(clave4)) {
			mostrarTODOS muestra = new mostrarTODOS(fecha);
			cadena = muestra.cadena;
		}
	}
}

class mostrarBC{
	String cadena="";
	@SuppressWarnings("unused")
	public mostrarBC(String fecha){
		String ruta="c:/Registro/archivos/BC/BD_BC.txt";
		try {
			File file = new File(ruta);
			FileReader fr = null;
			BufferedReader br = null;
			fr = new FileReader (file);
		    br = new BufferedReader(fr);
		    String linea;
		    while((linea=br.readLine())!=null){
		    	String[]parts = linea.split(",");
    			String nombre = parts[0];
    			String ID = parts[1];
    			String clave = parts[2];
    			String rutaAux="c:/Registro/archivos/BC/"+ID+"/"+fecha+".txt"; 
    			File temp = new File(rutaAux);
    			if (!temp.exists()) {
    			}else {
    				FileReader frAux = null;
    				BufferedReader brAux = null;
    				frAux = new FileReader (temp);
    		    	brAux = new BufferedReader(frAux);
    		    	String lineaAux="";
    		    	cadena = cadena+"El usuario: "+nombre+" con clave: "+ID+"\n";
    		    	while((lineaAux=brAux.readLine())!=null){
    		    		String[]parts2 = lineaAux.split(",");
    	    			String fechas = parts2[0];
    	    			String horas = parts2[1];
    	    			String modo = parts2[2];
    	    			cadena = cadena+"Registra "+modo+" el: "+fechas+" a las "+horas+" hrs. \n";
    		    	}
    		    	frAux.close();
    		    	brAux.close();
    		    	cadena=cadena+"\n";
    			}
		    }
		    br.close();
		    fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class mostrarCA{
	String cadena="";
	@SuppressWarnings("unused")
	public mostrarCA(String fecha){
		String ruta="c:/Registro/archivos/CA/BD_CA.txt";
		try {
			File file = new File(ruta);
			FileReader fr = null;
			BufferedReader br = null;
			fr = new FileReader (file);
		    br = new BufferedReader(fr);
		    String linea;
		    while((linea=br.readLine())!=null){
		    	String[]parts = linea.split(",");
    			String nombre = parts[0];
    			String ID = parts[1];
    			String clave = parts[2];
    			String rutaAux="c:/Registro/archivos/CA/"+ID+"/"+fecha+".txt"; 
    			File temp = new File(rutaAux);
    			if (!temp.exists()) {
    			}else {
    				FileReader frAux = null;
    				BufferedReader brAux = null;
    				frAux = new FileReader (temp);
    		    	brAux = new BufferedReader(frAux);
    		    	String lineaAux="";
    		    	cadena = cadena+"El usuario: "+nombre+" con clave: "+ID+"\n";
    		    	while((lineaAux=brAux.readLine())!=null){
    		    		String[]parts2 = lineaAux.split(",");
    	    			String fechas = parts2[0];
    	    			String horas = parts2[1];
    	    			String modo = parts2[2];
    	    			cadena = cadena+"Registra "+modo+" el: "+fechas+" a las "+horas+" hrs. \n";
    		    	}
    		    	frAux.close();
    		    	brAux.close();
    		    	cadena=cadena+"\n";
    			}
		    }
		    br.close();
		    fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class mostrarCB{
	String cadena="";
	@SuppressWarnings("unused")
	public mostrarCB(String fecha){
		String ruta="c:/Registro/archivos/CB/BD_CB.txt";
		try {
			File file = new File(ruta);
			FileReader fr = null;
			BufferedReader br = null;
			fr = new FileReader (file);
		    br = new BufferedReader(fr);
		    String linea;
		    while((linea=br.readLine())!=null){
		    	String[]parts = linea.split(",");
    			String nombre = parts[0];
    			String ID = parts[1];
    			String clave = parts[2];
    			String rutaAux="c:/Registro/archivos/CB/"+ID+"/"+fecha+".txt"; 
    			File temp = new File(rutaAux);
    			if (!temp.exists()) {
    			}else {
    				FileReader frAux = null;
    				BufferedReader brAux = null;
    				frAux = new FileReader (temp);
    		    	brAux = new BufferedReader(frAux);
    		    	String lineaAux="";
    		    	cadena = cadena+"El usuario: "+nombre+" con clave: "+ID+"\n";
    		    	while((lineaAux=brAux.readLine())!=null){
    		    		String[]parts2 = lineaAux.split(",");
    	    			String fechas = parts2[0];
    	    			String horas = parts2[1];
    	    			String modo = parts2[2];
    	    			cadena = cadena+"Registra "+modo+" el: "+fechas+" a las "+horas+" hrs. \n";
    		    	}
    		    	frAux.close();
    		    	brAux.close();
    		    	cadena=cadena+"\n";
    			}
		    }
		    br.close();
		    fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class mostrarTODOS{
	String cadena="";
	public mostrarTODOS(String fecha){
		String ruta="c:/Registro/archivos/BD.txt";
		try {
			File file = new File(ruta);
			FileReader fr = null;
			BufferedReader br = null;
			fr = new FileReader (file);
		    br = new BufferedReader(fr);
		    String linea;
		    while((linea=br.readLine())!=null){
		    	String[]parts = linea.split(",");
    			String nombre = parts[0];
    			String ID = parts[1];
    			String rutaAux="c:/Registro/archivos/ALL/"+ID+"/"+fecha+".txt"; 
    			File temp = new File(rutaAux);
    			if (!temp.exists()) {
    			}else {
    				FileReader frAux = null;
    				BufferedReader brAux = null;
    				frAux = new FileReader (temp);
    		    	brAux = new BufferedReader(frAux);
    		    	String lineaAux="";
    		    	cadena = cadena+"El usuario: "+nombre+" con clave: "+ID+"\n";
    		    	while((lineaAux=brAux.readLine())!=null){
    		    		String[]parts2 = lineaAux.split(",");
    	    			String fechas = parts2[0];
    	    			String horas = parts2[1];
    	    			String modo = parts2[2];
    	    			cadena = cadena+"Registra "+modo+" el: "+fechas+" a las "+horas+" hrs. \n";
    		    	}
    		    	frAux.close();
    		    	brAux.close();
    		    	cadena=cadena+"\n";
    			}
		    }
		    br.close();
		    fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
class ImprimeFinal{
	public ImprimeFinal(String cadena,String fecha, String clave) {
		String ruta="c:/Registro/archivos/REGISTROS/"+fecha+"_"+clave+".txt";
		try {
			File file = new File(ruta);
			if(file.exists()) {
		    	file.delete();
		    }
		    file.createNewFile();
			FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cadena);
            bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
@SuppressWarnings("serial")
class Imagen extends JPanel{
	public Imagen(){
		this.setSize(400,600);
	}
	@Override
	public void paint (Graphics pincel){
		super.paint(pincel);
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("fondo.png")).getImage());
		pincel.drawImage(imagen.getImage(),0,0,tam.width, tam.height,null);
    }
}

class CrearDirectorios {
	public CrearDirectorios(){
        File directorioRegistro = new File("c:/Registro");
        if (!directorioRegistro.exists()) {
            if (directorioRegistro.mkdirs()) {
            } else {
            }
        }
        File directorioArchivos = new File("c:/Registro/archivos");
        if (!directorioArchivos.exists()) {
            if (directorioArchivos.mkdirs()) {
            } else {
            }
        }
        File directorioBDALL = new File("c:/Registro/archivos/ALL");
        if (!directorioBDALL.exists()) {
            if (directorioBDALL.mkdirs()) {
            } else {
            }
        }
        File directorioBDBC = new File("c:/Registro/archivos/BC");
        if (!directorioBDBC.exists()) {
            if (directorioBDBC.mkdirs()) {
            } else {
            }
        }
        File directorioBDCA = new File("c:/Registro/archivos/CA");
        if (!directorioBDCA.exists()) {
            if (directorioBDCA.mkdirs()) {
            } else {
            }
        }
        File directorioBDCB = new File("c:/Registro/archivos/CB");
        if (!directorioBDCB.exists()) {
            if (directorioBDCB.mkdirs()) {
            } else {
            }
        }
        File archivo = null;
        try {
		    archivo = new File ("c:/Registro/archivos/BD.txt");
		    if(!archivo.exists()) {
		    	archivo.createNewFile();
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
        File archivoBC = null;
        try {
		    archivoBC = new File ("c:/Registro/archivos/BC/BD_BC.txt");
		    if(!archivoBC.exists()) {
		    	archivoBC.createNewFile();
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
        File archivoCA = null;
        try {
		    archivoCA = new File ("c:/Registro/archivos/CA/BD_CA.txt");
		    if(!archivoCA.exists()) {
		    	archivoCA.createNewFile();
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
        File archivoCB = null;
        try {
		    archivoCB = new File ("c:/Registro/archivos/CB/BD_CB.txt");
		    if(!archivoCB.exists()) {
		    	archivoCB.createNewFile();
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
}

class creaCarpeta{
	public creaCarpeta(String nombreCarpeta, String clave,String nombre){
		String rutaCompleta="c:/Registro/archivos/"+clave+"/"+nombreCarpeta;
        File directorioArchivos = new File(rutaCompleta);
        if (!directorioArchivos.exists()) {
            if (directorioArchivos.mkdirs()) {
            } else {
            }
        }else {
        }
        String ruta2="c:/Registro/archivos/ALL/"+nombreCarpeta;
        File todoReg = new File(ruta2);
        if(!todoReg.exists()) {
        	if (todoReg.mkdirs()) {
            } else {
            }
        }else {
        }
        BufferedWriter bw = null;
		FileWriter fw = null;
		String rutaParcial = "c:/Registro/archivos/"+clave+"/BD_"+clave+".txt";
		String cadena=nombre+","+nombreCarpeta+","+clave;
		try {
			File file = new File(rutaParcial);
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(cadena);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			    if (bw != null)
			        bw.close();
			    if (fw != null)
			        fw.close();
			} catch (IOException ex) {
			    ex.printStackTrace();
			}
		}
    }
}