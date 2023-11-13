namespace miPrimerProyecto3
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
            gridviewDatos = new DataGridView();
            Nombre = new DataGridViewTextBoxColumn();
            Apellidos = new DataGridViewTextBoxColumn();
            Telefono = new DataGridViewTextBoxColumn();
            btAnadir = new Button();
            ((System.ComponentModel.ISupportInitialize)gridviewDatos).BeginInit();
            SuspendLayout();
            // 
            // gridviewDatos
            // 
            gridviewDatos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            gridviewDatos.Columns.AddRange(new DataGridViewColumn[] { Nombre, Apellidos, Telefono });
            gridviewDatos.Location = new Point(170, 72);
            gridviewDatos.Name = "gridviewDatos";
            gridviewDatos.RowHeadersWidth = 51;
            gridviewDatos.RowTemplate.Height = 29;
            gridviewDatos.Size = new Size(444, 302);
            gridviewDatos.TabIndex = 0;
            // 
            // Nombre
            // 
            Nombre.HeaderText = "Nombre";
            Nombre.MinimumWidth = 6;
            Nombre.Name = "Nombre";
            Nombre.Width = 125;
            // 
            // Apellidos
            // 
            Apellidos.HeaderText = "Apellidos";
            Apellidos.MinimumWidth = 6;
            Apellidos.Name = "Apellidos";
            Apellidos.Width = 125;
            // 
            // Telefono
            // 
            Telefono.HeaderText = "Telefono";
            Telefono.MinimumWidth = 6;
            Telefono.Name = "Telefono";
            Telefono.Width = 125;
            // 
            // btAnadir
            // 
            btAnadir.Location = new Point(339, 380);
            btAnadir.Name = "btAnadir";
            btAnadir.Size = new Size(94, 29);
            btAnadir.TabIndex = 1;
            btAnadir.Text = "Añadir";
            btAnadir.UseVisualStyleBackColor = true;
            btAnadir.Click += btAnadir_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btAnadir);
            Controls.Add(gridviewDatos);
            Name = "Form1";
            Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)gridviewDatos).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private DataGridView gridviewDatos;
        private Button btAnadir;
        private DataGridViewTextBoxColumn Nombre;
        private DataGridViewTextBoxColumn Apellidos;
        private DataGridViewTextBoxColumn Telefono;
    }
}