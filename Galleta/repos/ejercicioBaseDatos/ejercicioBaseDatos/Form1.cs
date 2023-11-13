using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ejercicioBaseDatos
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        class BaseDatosAlumnos
        {
            private OleDbConnection Conexion; // Declaración de la conexión con la BD
            private OleDbCommand Comando; // Declaración del comando con sentencias SQL
            private OleDbDataReader Lector; // Declaración del lector de datos
            public void LeerDeBaseDeDatos()
            {
                // Declaración de la cadena de conexión
                string CadenaConexion = @"Provider=Microsoft.ACE.OLEDB.12.0; 
                Data Source=C:\Users\Instituto\Documents\ejercicioBaseDatos.accdb";
                Conexion = new OleDbConnection(CadenaConexion); // Crear la conexión con la BD
                string Consulta = "SELECT * FROM ejercicioBaseDatos"; // Declaración de la consulta
                Comando = new OleDbCommand(Consulta, Conexion); // Declaración del comando de consulta en la conexión con la BD
                Conexion.Open(); // Abrir la BD
                Lector = Comando.ExecuteReader(); // Ejecutar el comando lector de datos
                while (Lector.Read())
                {
                    Console.WriteLine(Lector.GetString(0) + " " + Lector.GetString(1) + " " + Lector.GetValue(2).ToString());
                }
                Lector.Close(); // Cerrar el lector de datos
                Lector = null;
            }
            public void CerrarConexion()
            {
                // Verifica si está activa la lectura
                if (Lector != null)
                    Lector.Close();
                // Verifica si está abierta la conexión con la BD
                if (Conexion != null)
                    Conexion.Close();
            }
        }
    }
}
