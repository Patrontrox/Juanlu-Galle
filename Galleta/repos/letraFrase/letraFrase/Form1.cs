
namespace letraFrase
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int contador = 0;
            String a = textBox2.Text;
            Char b = textBox1.Text[0];

           
            foreach (char c in a)
            {
                if (c == b)
                contador++;
            }
            textBox3.Text = contador.ToString();
            
        }
    }
}