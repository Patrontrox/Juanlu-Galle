namespace miPrimerProyecto3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }



        private void btAnadir_Click(object sender, EventArgs e)
        {

            formFormulario prueba = new formFormulario();
            if (prueba.ShowDialog(this) == DialogResult.OK)
            {
                var index = gridviewDatos.Rows.Add();
                gridviewDatos.Rows[index].Cells["Nombre"].Value = prueba.txtNombre.Text;
                gridviewDatos.Rows[index].Cells["Apellidos"].Value = prueba.txtApellidos.Text;
                gridviewDatos.Rows[index].Cells["Telefono"].Value = prueba.txtTelefono.Text;
            }

        }

        private void btOk_Click(object sender, EventArgs e)
        {

        }
    }
}