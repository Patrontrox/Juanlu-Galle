namespace miPrimerProyecto3
{
    partial class formFormulario
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
            txtNombre = new TextBox();
            lbNombre = new Label();
            lbApellidos = new Label();
            txtApellidos = new TextBox();
            lbTelefono = new Label();
            txtTelefono = new TextBox();
            btOk2 = new Button();
            btCancelar = new Button();
            SuspendLayout();
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(155, 132);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(125, 27);
            txtNombre.TabIndex = 0;
            // 
            // lbNombre
            // 
            lbNombre.AutoSize = true;
            lbNombre.Location = new Point(85, 135);
            lbNombre.Name = "lbNombre";
            lbNombre.Size = new Size(64, 20);
            lbNombre.TabIndex = 1;
            lbNombre.Text = "Nombre";
            // 
            // lbApellidos
            // 
            lbApellidos.AutoSize = true;
            lbApellidos.Location = new Point(85, 178);
            lbApellidos.Name = "lbApellidos";
            lbApellidos.Size = new Size(72, 20);
            lbApellidos.TabIndex = 3;
            lbApellidos.Text = "Apellidos";
            // 
            // txtApellidos
            // 
            txtApellidos.Location = new Point(155, 175);
            txtApellidos.Name = "txtApellidos";
            txtApellidos.Size = new Size(125, 27);
            txtApellidos.TabIndex = 2;
            // 
            // lbTelefono
            // 
            lbTelefono.AutoSize = true;
            lbTelefono.Location = new Point(85, 222);
            lbTelefono.Name = "lbTelefono";
            lbTelefono.Size = new Size(67, 20);
            lbTelefono.TabIndex = 5;
            lbTelefono.Text = "Telefono";
            // 
            // txtTelefono
            // 
            txtTelefono.Location = new Point(155, 219);
            txtTelefono.Name = "txtTelefono";
            txtTelefono.Size = new Size(125, 27);
            txtTelefono.TabIndex = 4;
            // 
            // btOk2
            // 
            btOk2.DialogResult = DialogResult.OK;
            btOk2.Location = new Point(164, 266);
            btOk2.Name = "btOk2";
            btOk2.Size = new Size(94, 29);
            btOk2.TabIndex = 6;
            btOk2.Text = "OK";
            btOk2.UseVisualStyleBackColor = true;
            btOk2.Click += btOk2_Click;
            // 
            // btCancelar
            // 
            btCancelar.DialogResult = DialogResult.Cancel;
            btCancelar.Location = new Point(164, 301);
            btCancelar.Name = "btCancelar";
            btCancelar.Size = new Size(94, 29);
            btCancelar.TabIndex = 7;
            btCancelar.Text = "Cancelar";
            btCancelar.UseVisualStyleBackColor = true;
            // 
            // formFormulario
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(395, 462);
            Controls.Add(btCancelar);
            Controls.Add(btOk2);
            Controls.Add(lbTelefono);
            Controls.Add(txtTelefono);
            Controls.Add(lbApellidos);
            Controls.Add(txtApellidos);
            Controls.Add(lbNombre);
            Controls.Add(txtNombre);
            Name = "formFormulario";
            Text = "Registro";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        public TextBox txtNombre;
        public Label lbNombre;
        public Label lbApellidos;
        public TextBox txtApellidos;
        public Label lbTelefono;
        public TextBox txtTelefono;
        public Button btOk2;
        public Button btCancelar;
    }
}