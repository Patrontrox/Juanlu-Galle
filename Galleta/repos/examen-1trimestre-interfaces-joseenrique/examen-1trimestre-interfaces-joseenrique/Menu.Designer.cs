namespace examen_1trimestre_interfaces_joseenrique
{
    partial class formMenu
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
            menustripMenu = new MenuStrip();
            alumnosToolStripMenuItem = new ToolStripMenuItem();
            buscadorToolStripMenuItem = new ToolStripMenuItem();
            btSalir = new Button();
            menustripMenu.SuspendLayout();
            SuspendLayout();
            // 
            // menustripMenu
            // 
            menustripMenu.Font = new Font("Segoe UI", 20F, FontStyle.Regular, GraphicsUnit.Point);
            menustripMenu.ImageScalingSize = new Size(20, 20);
            menustripMenu.Items.AddRange(new ToolStripItem[] { alumnosToolStripMenuItem, buscadorToolStripMenuItem });
            menustripMenu.Location = new Point(0, 0);
            menustripMenu.Name = "menustripMenu";
            menustripMenu.Size = new Size(1521, 54);
            menustripMenu.TabIndex = 0;
            // 
            // alumnosToolStripMenuItem
            // 
            alumnosToolStripMenuItem.Name = "alumnosToolStripMenuItem";
            alumnosToolStripMenuItem.Size = new Size(165, 50);
            alumnosToolStripMenuItem.Text = "Alumnos";
            alumnosToolStripMenuItem.Click += alumnosToolStripMenuItem_Click;
            // 
            // buscadorToolStripMenuItem
            // 
            buscadorToolStripMenuItem.Name = "buscadorToolStripMenuItem";
            buscadorToolStripMenuItem.Size = new Size(171, 50);
            buscadorToolStripMenuItem.Text = "Buscador";
            buscadorToolStripMenuItem.Click += buscadorToolStripMenuItem_Click;
            // 
            // btSalir
            // 
            btSalir.Anchor = AnchorStyles.Bottom | AnchorStyles.Right;
            btSalir.FlatAppearance.MouseDownBackColor = Color.Red;
            btSalir.Location = new Point(1383, 576);
            btSalir.Name = "btSalir";
            btSalir.Size = new Size(126, 48);
            btSalir.TabIndex = 3;
            btSalir.Text = "Salir";
            btSalir.UseVisualStyleBackColor = true;
            btSalir.Click += btSalir_Click;
            // 
            // formMenu
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Bisque;
            ClientSize = new Size(1521, 636);
            Controls.Add(btSalir);
            Controls.Add(menustripMenu);
            MainMenuStrip = menustripMenu;
            Name = "formMenu";
            Text = "Menú";
            menustripMenu.ResumeLayout(false);
            menustripMenu.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menustripMenu;
        private ToolStripMenuItem alumnosToolStripMenuItem;
        private ToolStripMenuItem buscadorToolStripMenuItem;
        private Button btSalir;
    }
}