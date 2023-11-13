using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace examen_1trimestre_interfaces_joseenrique
{
    public partial class formAlumnosAnadir : Form
    {
        public formAlumnosAnadir()
        {
            InitializeComponent();
        }

        private void btAnadirAlumno_Click(object sender, EventArgs e)
        {
            if (txtNota1Anadir.Text == "")
            {
                txtNota1Anadir.Text = "-";
            }
            if (txtNota2Anadir.Text == "")
            {
                txtNota2Anadir.Text = "-";
            }
            if (txtNota3Anadir.Text == "")
            {
                txtNota3Anadir.Text = "-";
            }
        }

        private void btSalirAnadir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
