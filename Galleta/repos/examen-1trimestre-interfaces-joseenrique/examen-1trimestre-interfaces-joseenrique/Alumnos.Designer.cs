namespace examen_1trimestre_interfaces_joseenrique
{
    partial class formAlumnos
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
            menustripAlumnos = new MenuStrip();
            añadirToolStripMenuItem = new ToolStripMenuItem();
            borrarToolStripMenuItem = new ToolStripMenuItem();
            modificarToolStripMenuItem = new ToolStripMenuItem();
            datagridAlumnos = new DataGridView();
            cellCodigo = new DataGridViewTextBoxColumn();
            cellNombre = new DataGridViewTextBoxColumn();
            cellApellidos = new DataGridViewTextBoxColumn();
            cellTelefono = new DataGridViewTextBoxColumn();
            cellDNI = new DataGridViewTextBoxColumn();
            cellLocalidad = new DataGridViewTextBoxColumn();
            cellNotas = new DataGridViewTextBoxColumn();
            cellNotaMedia = new DataGridViewTextBoxColumn();
            btSalir = new Button();
            menustripAlumnos.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)datagridAlumnos).BeginInit();
            SuspendLayout();
            // 
            // menustripAlumnos
            // 
            menustripAlumnos.Font = new Font("Segoe UI", 20F, FontStyle.Regular, GraphicsUnit.Point);
            menustripAlumnos.ImageScalingSize = new Size(20, 20);
            menustripAlumnos.Items.AddRange(new ToolStripItem[] { añadirToolStripMenuItem, borrarToolStripMenuItem, modificarToolStripMenuItem });
            menustripAlumnos.Location = new Point(0, 0);
            menustripAlumnos.Name = "menustripAlumnos";
            menustripAlumnos.Size = new Size(1521, 54);
            menustripAlumnos.TabIndex = 0;
            menustripAlumnos.Text = "menuStrip1";
            // 
            // añadirToolStripMenuItem
            // 
            añadirToolStripMenuItem.Name = "añadirToolStripMenuItem";
            añadirToolStripMenuItem.Size = new Size(132, 50);
            añadirToolStripMenuItem.Text = "Añadir";
            añadirToolStripMenuItem.Click += añadirToolStripMenuItem_Click;
            // 
            // borrarToolStripMenuItem
            // 
            borrarToolStripMenuItem.Name = "borrarToolStripMenuItem";
            borrarToolStripMenuItem.Size = new Size(126, 50);
            borrarToolStripMenuItem.Text = "Borrar";
            borrarToolStripMenuItem.Click += borrarToolStripMenuItem_Click;
            // 
            // modificarToolStripMenuItem
            // 
            modificarToolStripMenuItem.Name = "modificarToolStripMenuItem";
            modificarToolStripMenuItem.Size = new Size(177, 50);
            modificarToolStripMenuItem.Text = "Modificar";
            modificarToolStripMenuItem.Click += modificarToolStripMenuItem_Click;
            // 
            // datagridAlumnos
            // 
            datagridAlumnos.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            datagridAlumnos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            datagridAlumnos.Columns.AddRange(new DataGridViewColumn[] { cellCodigo, cellNombre, cellApellidos, cellTelefono, cellDNI, cellLocalidad, cellNotas, cellNotaMedia });
            datagridAlumnos.Location = new Point(38, 96);
            datagridAlumnos.Name = "datagridAlumnos";
            datagridAlumnos.RowHeadersWidth = 51;
            datagridAlumnos.RowTemplate.Height = 29;
            datagridAlumnos.Size = new Size(1435, 488);
            datagridAlumnos.TabIndex = 1;
            // 
            // cellCodigo
            // 
            cellCodigo.HeaderText = "Código";
            cellCodigo.MinimumWidth = 6;
            cellCodigo.Name = "cellCodigo";
            cellCodigo.Width = 125;
            // 
            // cellNombre
            // 
            cellNombre.HeaderText = "Nombre";
            cellNombre.MinimumWidth = 6;
            cellNombre.Name = "cellNombre";
            cellNombre.Width = 125;
            // 
            // cellApellidos
            // 
            cellApellidos.HeaderText = "Apellidos";
            cellApellidos.MinimumWidth = 6;
            cellApellidos.Name = "cellApellidos";
            cellApellidos.Width = 125;
            // 
            // cellTelefono
            // 
            cellTelefono.HeaderText = "Teléfono";
            cellTelefono.MinimumWidth = 6;
            cellTelefono.Name = "cellTelefono";
            cellTelefono.Width = 125;
            // 
            // cellDNI
            // 
            cellDNI.HeaderText = "DNI";
            cellDNI.MinimumWidth = 6;
            cellDNI.Name = "cellDNI";
            cellDNI.Width = 125;
            // 
            // cellLocalidad
            // 
            cellLocalidad.HeaderText = "Localidad";
            cellLocalidad.MinimumWidth = 6;
            cellLocalidad.Name = "cellLocalidad";
            cellLocalidad.Width = 125;
            // 
            // cellNotas
            // 
            cellNotas.HeaderText = "Notas";
            cellNotas.MinimumWidth = 6;
            cellNotas.Name = "cellNotas";
            cellNotas.Width = 125;
            // 
            // cellNotaMedia
            // 
            cellNotaMedia.HeaderText = "Nota Media";
            cellNotaMedia.MinimumWidth = 6;
            cellNotaMedia.Name = "cellNotaMedia";
            cellNotaMedia.Width = 125;
            // 
            // btSalir
            // 
            btSalir.Anchor = AnchorStyles.Bottom | AnchorStyles.Right;
            btSalir.FlatAppearance.MouseDownBackColor = Color.Red;
            btSalir.Location = new Point(1415, 595);
            btSalir.Name = "btSalir";
            btSalir.Size = new Size(94, 29);
            btSalir.TabIndex = 2;
            btSalir.Text = "Salir";
            btSalir.UseVisualStyleBackColor = true;
            btSalir.Click += btSalir_Click;
            // 
            // formAlumnos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Bisque;
            ClientSize = new Size(1521, 636);
            Controls.Add(btSalir);
            Controls.Add(datagridAlumnos);
            Controls.Add(menustripAlumnos);
            MainMenuStrip = menustripAlumnos;
            Name = "formAlumnos";
            Text = "Alumnos";
            menustripAlumnos.ResumeLayout(false);
            menustripAlumnos.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)datagridAlumnos).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        public MenuStrip menustripAlumnos;
        public ToolStripMenuItem añadirToolStripMenuItem;
        public ToolStripMenuItem borrarToolStripMenuItem;
        public ToolStripMenuItem modificarToolStripMenuItem;
        public DataGridView datagridAlumnos;
        private Button btSalir;
        private DataGridViewTextBoxColumn cellCodigo;
        private DataGridViewTextBoxColumn cellNombre;
        private DataGridViewTextBoxColumn cellApellidos;
        private DataGridViewTextBoxColumn cellTelefono;
        private DataGridViewTextBoxColumn cellDNI;
        private DataGridViewTextBoxColumn cellLocalidad;
        private DataGridViewTextBoxColumn cellNotas;
        private DataGridViewTextBoxColumn cellNotaMedia;
    }
}