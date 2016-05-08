/**
 * 
 */
package br.com.devnagui.project.dbunitils;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.unitils.dbunit.datasetloadstrategy.impl.BaseDataSetLoadStrategy;
import org.unitils.dbunit.util.DbUnitDatabaseConnection;

/**
 * 
 * It clean all table before the test
 *
 */
public class CleanInsertDataSetLoadStrategy extends BaseDataSetLoadStrategy {
	private static final Logger LOG = Logger
			.getLogger(CleanInsertDataSetLoadStrategy.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.unitils.dbunit.datasetloadstrategy.impl.BaseDataSetLoadStrategy#doExecute
	 * (org.unitils.dbunit.util.DbUnitDatabaseConnection,
	 * org.dbunit.dataset.IDataSet)
	 */
	@Override
	protected void doExecute(DbUnitDatabaseConnection dbUnitDatabaseConnection,
			IDataSet dataSet) throws DatabaseUnitException, SQLException {
        LOG.info("Limpando a base de dados antes dos testes.");
        DatabaseOperation.TRUNCATE_TABLE.execute(dbUnitDatabaseConnection, dataSet);
        LOG.info("Base de dados limpa. Inserindo registros");
        DatabaseOperation.INSERT.execute(dbUnitDatabaseConnection, dataSet);
        LOG.info("Registros inseridos com sucesso.");
        dbUnitDatabaseConnection.closeJdbcConnection();
        dbUnitDatabaseConnection.getConnection().commit();

	}

}
