using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.DataFormats;

namespace examen_1trimestre_interfaces_joseenrique
{
    public partial class formAlumnos : Form
    {
        string[,] datos = new string[,]
            {
                { "1", "José","Gallego León", "677712339", "49106930L", "Sevilla" , "3,7,9", "0" },
                { "2", "Enrique","León Gallego", "654892364", "92846145M", "Huelva", "9,9,0", "0" },
                { "3", "Belén","Ortega Guerra", "724917883", "42840185T", "Malaga", "8,9,6", "0" },
                { "4", "Pedro","Dominguez Santillana", "735876193", "65482730P", "Cadiz", "5,8,7", "0" },

            };
        private double notaMediaCurso;
        public formAlumnos()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.None;
            WindowState = FormWindowState.Maximized;

            for (int i = 0; i < datos.GetLength(0); i++)
            {

                datagridAlumnos.Rows.Add(new string[]
                    {
                    datos[i, 0],
                    datos[i, 1],
                    datos[i, 2],
                    datos[i, 3],
                    datos[i, 4],
                    datos[i, 5],
                    datos[i, 6],
                    datos[i, 7],
                    });
            }
        }

        private void añadirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            formAlumnosAnadir anadirAlumnos = new formAlumnosAnadir();
            anadirAlumnos.ShowDialog();

            if (anadirAlumnos.DialogResult == DialogResult.OK)
            {
                var index = datagridAlumnos.Rows.Add();
                datagridAlumnos.Rows[index].Cells["cellCodigo"].Value = anadirAlumnos.txtCodigoAnadir.Text;
                datagridAlumnos.Rows[index].Cells["cellNombre"].Value = anadirAlumnos.txtNombreAnadir.Text;
                datagridAlumnos.Rows[index].Cells["cellApellidos"].Value = anadirAlumnos.txtApellidosAnadir.Text;
                datagridAlumnos.Rows[index].Cells["cellDNI"].Value = anadirAlumnos.txtDNIAnadir.Text;
                datagridAlumnos.Rows[index].Cells["cellTelefono"].Value = anadirAlumnos.txtTelefonoAnadir.Text;
                datagridAlumnos.Rows[index].Cells["cellLocalidad"].Value = anadirAlumnos.txtLocalidadAnadir.Text;
                datagridAlumnos.Rows[index].Cells["cellNotas"].Value = $"{anadirAlumnos.txtNota1Anadir.Text},{anadirAlumnos.txtNota2Anadir.Text},{anadirAlumnos.txtNota3Anadir.Text}";
                if (anadirAlumnos.txtNota1Anadir.Text == "")
                {
                    anadirAlumnos.txtNota1Anadir.Text = "0";
                    datagridAlumnos.Rows[index].Cells["cellNotaMedia"].Value = ((0 + double.Parse(anadirAlumnos.txtNota2Anadir.Text) + double.Parse(anadirAlumnos.txtNota3Anadir.Text)) / 3).ToString();

                }
                if (anadirAlumnos.txtNota2Anadir.Text == "")
                {
                    anadirAlumnos.txtNota2Anadir.Text = "0";
                    datagridAlumnos.Rows[index].Cells["cellNotaMedia"].Value = ((double.Parse(anadirAlumnos.txtNota1Anadir.Text) + 0 + double.Parse(anadirAlumnos.txtNota3Anadir.Text)) / 3).ToString();

                }
                if (anadirAlumnos.txtNota3Anadir.Text == "")
                {
                    anadirAlumnos.txtNota3Anadir.Text = "0";
                    datagridAlumnos.Rows[index].Cells["cellNotaMedia"].Value = ((double.Parse(anadirAlumnos.txtNota1Anadir.Text) + double.Parse(anadirAlumnos.txtNota2Anadir.Text) + 0) / 3).ToString();

                }

                if (anadirAlumnos.txtNota1Anadir.Text == "" && anadirAlumnos.txtNota2Anadir.Text == "" && anadirAlumnos.txtNota3Anadir.Text == "")
                {
                    datagridAlumnos.Rows[index].Cells["cellNotaMedia"].Value = "0";

                }

            }

        }

        private void borrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            formAlumnosBorrar borrarAlumno = new formAlumnosBorrar();
            borrarAlumno.ShowDialog();

            int code = int.Parse(borrarAlumno.txtCodigoBorrar.Text);

            if (borrarAlumno.DialogResult == DialogResult.OK)
            {
                datagridAlumnos.Rows.RemoveAt(code - 1);
            }
        }

        private void modificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        private void btSalir_Click(object sender, EventArgs e)
        {
            formMenu menu = new formMenu();
            menu.Show();
            this.Close();
        }
    }
}
