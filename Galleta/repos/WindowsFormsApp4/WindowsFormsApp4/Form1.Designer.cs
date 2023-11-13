namespace WindowsFormsApp4
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this._Database7_accdbDataSet = new WindowsFormsApp4._Database7_accdbDataSet();
            this.tabla1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tabla1TableAdapter = new WindowsFormsApp4._Database7_accdbDataSetTableAdapters.Tabla1TableAdapter();
            this.tabla1BindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this._Database7_accdbDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tabla1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tabla1BindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.DataSource = this.tabla1BindingSource1;
            this.dataGridView1.Location = new System.Drawing.Point(141, 210);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(365, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // _Database7_accdbDataSet
            // 
            this._Database7_accdbDataSet.DataSetName = "_Database7_accdbDataSet";
            this._Database7_accdbDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // tabla1BindingSource
            // 
            this.tabla1BindingSource.DataMember = "Tabla1";
            this.tabla1BindingSource.DataSource = this._Database7_accdbDataSet;
            // 
            // tabla1TableAdapter
            // 
            this.tabla1TableAdapter.ClearBeforeFill = true;
            // 
            // tabla1BindingSource1
            // 
            this.tabla1BindingSource1.DataMember = "Tabla1";
            this.tabla1BindingSource1.DataSource = this._Database7_accdbDataSet;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this._Database7_accdbDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tabla1BindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tabla1BindingSource1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private _Database7_accdbDataSet _Database7_accdbDataSet;
        private System.Windows.Forms.BindingSource tabla1BindingSource;
        private _Database7_accdbDataSetTableAdapters.Tabla1TableAdapter tabla1TableAdapter;
        private System.Windows.Forms.BindingSource tabla1BindingSource1;
    }
}

