namespace examen_1trimestre_interfaces_joseenrique
{
    public partial class formMenu : Form
    {
        public formMenu()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.None;
            WindowState = FormWindowState.Maximized;

        }

        private void alumnosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            formAlumnos pantallaAlumnos = new formAlumnos();
            pantallaAlumnos.Show();
            this.Hide();
        }

        private void buscadorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            formBuscador pantallaBuscador = new formBuscador();
            pantallaBuscador.Show();
            this.Hide();
        }

        private void btSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}