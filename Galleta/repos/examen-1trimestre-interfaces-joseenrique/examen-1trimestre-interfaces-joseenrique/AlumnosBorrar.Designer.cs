namespace examen_1trimestre_interfaces_joseenrique
{
    partial class formAlumnosBorrar
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lbTituloBorrar = new Label();
            lbCodigoBorrar = new Label();
            txtCodigoBorrar = new TextBox();
            btSalirAnadir = new Button();
            btBorrarAlumno = new Button();
            SuspendLayout();
            // 
            // lbTituloBorrar
            // 
            lbTituloBorrar.AutoSize = true;
            lbTituloBorrar.Font = new Font("Segoe UI", 20F, FontStyle.Bold, GraphicsUnit.Point);
            lbTituloBorrar.Location = new Point(266, 57);
            lbTituloBorrar.Name = "lbTituloBorrar";
            lbTituloBorrar.Size = new Size(123, 46);
            lbTituloBorrar.TabIndex = 0;
            lbTituloBorrar.Text = "Borrar";
            // 
            // lbCodigoBorrar
            // 
            lbCodigoBorrar.AutoSize = true;
            lbCodigoBorrar.Font = new Font("Segoe UI", 15F, FontStyle.Regular, GraphicsUnit.Point);
            lbCodigoBorrar.Location = new Point(142, 125);
            lbCodigoBorrar.Name = "lbCodigoBorrar";
            lbCodigoBorrar.Size = new Size(96, 35);
            lbCodigoBorrar.TabIndex = 1;
            lbCodigoBorrar.Text = "Codigo";
            // 
            // txtCodigoBorrar
            // 
            txtCodigoBorrar.Location = new Point(264, 134);
            txtCodigoBorrar.Name = "txtCodigoBorrar";
            txtCodigoBorrar.Size = new Size(125, 27);
            txtCodigoBorrar.TabIndex = 2;
            // 
            // btSalirAnadir
            // 
            btSalirAnadir.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            btSalirAnadir.FlatAppearance.MouseDownBackColor = Color.Red;
            btSalirAnadir.Location = new Point(281, 241);
            btSalirAnadir.Name = "btSalirAnadir";
            btSalirAnadir.Size = new Size(94, 28);
            btSalirAnadir.TabIndex = 25;
            btSalirAnadir.Text = "Salir";
            btSalirAnadir.UseVisualStyleBackColor = true;
            btSalirAnadir.Click += btSalirAnadir_Click;
            // 
            // btBorrarAlumno
            // 
            btBorrarAlumno.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            btBorrarAlumno.DialogResult = DialogResult.OK;
            btBorrarAlumno.FlatAppearance.MouseDownBackColor = Color.Lime;
            btBorrarAlumno.ForeColor = SystemColors.ActiveCaptionText;
            btBorrarAlumno.Location = new Point(258, 206);
            btBorrarAlumno.Name = "btBorrarAlumno";
            btBorrarAlumno.Size = new Size(135, 28);
            btBorrarAlumno.TabIndex = 24;
            btBorrarAlumno.Text = "Borrar Alumno";
            btBorrarAlumno.UseVisualStyleBackColor = true;
            // 
            // formAlumnosBorrar
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Bisque;
            ClientSize = new Size(677, 446);
            Controls.Add(btSalirAnadir);
            Controls.Add(btBorrarAlumno);
            Controls.Add(txtCodigoBorrar);
            Controls.Add(lbCodigoBorrar);
            Controls.Add(lbTituloBorrar);
            Name = "formAlumnosBorrar";
            Text = "Borrar Alumnos";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        public Label lbTituloBorrar;
        public Label lbCodigoBorrar;
        public TextBox txtCodigoBorrar;
        public Button btSalirAnadir;
        public Button btBorrarAlumno;
    }
}