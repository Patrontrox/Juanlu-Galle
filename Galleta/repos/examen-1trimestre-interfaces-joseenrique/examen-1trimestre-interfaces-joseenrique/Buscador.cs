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
    public partial class formBuscador : Form
    {
        public formBuscador()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.None;
            WindowState = FormWindowState.Maximized;

        }

        private void btSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
