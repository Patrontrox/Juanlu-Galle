namespace examen_1trimestre_interfaces_joseenrique
{
    partial class formBuscador
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
            lbTituloBuscador = new Label();
            btSalir = new Button();
            SuspendLayout();
            // 
            // lbTituloBuscador
            // 
            lbTituloBuscador.AutoSize = true;
            lbTituloBuscador.BackColor = Color.Transparent;
            lbTituloBuscador.Font = new Font("Segoe UI", 20F, FontStyle.Bold, GraphicsUnit.Point);
            lbTituloBuscador.Location = new Point(672, 87);
            lbTituloBuscador.Name = "lbTituloBuscador";
            lbTituloBuscador.Size = new Size(168, 46);
            lbTituloBuscador.TabIndex = 0;
            lbTituloBuscador.Text = "Buscador";
            // 
            // btSalir
            // 
            btSalir.Anchor = AnchorStyles.Bottom | AnchorStyles.Right;
            btSalir.FlatAppearance.MouseDownBackColor = Color.Red;
            btSalir.Location = new Point(1383, 576);
            btSalir.Name = "btSalir";
            btSalir.Size = new Size(126, 48);
            btSalir.TabIndex = 4;
            btSalir.Text = "Salir";
            btSalir.UseVisualStyleBackColor = true;
            btSalir.Click += btSalir_Click;
            // 
            // formBuscador
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Bisque;
            ClientSize = new Size(1521, 636);
            Controls.Add(btSalir);
            Controls.Add(lbTituloBuscador);
            Name = "formBuscador";
            Text = "Buscador";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lbTituloBuscador;
        private Button btSalir;
    }
}