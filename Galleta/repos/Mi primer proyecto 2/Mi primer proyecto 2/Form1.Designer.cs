namespace Mi_primer_proyecto_2
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            n1 = new TextBox();
            n2 = new TextBox();
            sumar = new Button();
            restar = new Button();
            multiplicar = new Button();
            dividir = new Button();
            textBox1 = new TextBox();
            label1 = new Label();
            SuspendLayout();
            // 
            // n1
            // 
            n1.Location = new Point(319, 105);
            n1.Name = "n1";
            n1.Size = new Size(139, 27);
            n1.TabIndex = 0;
            // 
            // n2
            // 
            n2.Location = new Point(319, 150);
            n2.Name = "n2";
            n2.Size = new Size(139, 27);
            n2.TabIndex = 1;
            // 
            // sumar
            // 
            sumar.Location = new Point(278, 242);
            sumar.Name = "sumar";
            sumar.Size = new Size(53, 29);
            sumar.TabIndex = 2;
            sumar.Text = "+";
            sumar.UseVisualStyleBackColor = true;
            sumar.Click += button1_Click;
            // 
            // restar
            // 
            restar.Location = new Point(337, 242);
            restar.Name = "restar";
            restar.Size = new Size(53, 29);
            restar.TabIndex = 3;
            restar.Text = "-";
            restar.UseVisualStyleBackColor = true;
            // 
            // multiplicar
            // 
            multiplicar.Location = new Point(396, 242);
            multiplicar.Name = "multiplicar";
            multiplicar.Size = new Size(53, 29);
            multiplicar.TabIndex = 4;
            multiplicar.Text = "x";
            multiplicar.UseVisualStyleBackColor = true;
            // 
            // dividir
            // 
            dividir.Location = new Point(455, 242);
            dividir.Name = "dividir";
            dividir.Size = new Size(53, 29);
            dividir.TabIndex = 5;
            dividir.Text = "%";
            dividir.UseVisualStyleBackColor = true;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(319, 209);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(139, 27);
            textBox1.TabIndex = 6;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(254, 105);
            label1.Name = "label1";
            label1.Size = new Size(50, 20);
            label1.TabIndex = 7;
            label1.Text = "label1";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label1);
            Controls.Add(textBox1);
            Controls.Add(dividir);
            Controls.Add(multiplicar);
            Controls.Add(restar);
            Controls.Add(sumar);
            Controls.Add(n2);
            Controls.Add(n1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox n1;
        private TextBox n2;
        private Button sumar;
        private Button restar;
        private Button multiplicar;
        private Button dividir;
        private TextBox textBox1;
        private Label label1;
    }
}