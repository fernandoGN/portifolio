/**
 * Criado por 006157C6 em 26/04/2013
 */
package br.com.devnagui.project.dbunitils;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.unitils.dbunit.datasetloadstrategy.impl.RefreshLoadStrategy;
import org.unitils.dbunit.util.DbUnitDatabaseConnection;

/**
 * Created in replace for
 * RefreshLoadStrategy because it lock the database row after the tests.
 * 
 */
public class InsertOrUpdateWithCommitLoadStrategy extends RefreshLoadStrategy {

	// ATRIBUTOS E CONSTRUTORES

	private static final Logger LOG = Logger.getLogger(InsertOrUpdateWithCommitLoadStrategy.class);

	// METODOS PUBLICOS

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.devnagui.project.dbunitils.InsertOrUpdateWithCommitLoadStrategy
	 * #doExecute (org.unitils.dbunit.util.DbUnitDatabaseConnection,
	 * org.dbunit.dataset.IDataSet)
	 */
	@Override
	public void doExecute(DbUnitDatabaseConnection dbUnitDatabaseConnection, IDataSet dataSet) throws DatabaseUnitException, SQLException {
		LOG.info("Inserting or updating dataset.");

		try {
            for (String nomeTabela : dataSet.getTableNames()){
                LOG.info("Name of table that dbunit is using: " + nomeTabela);
            }
            super.doExecute(dbUnitDatabaseConnection, dataSet);
			LOG.info("Operation finished. Commiting changes.");
			dbUnitDatabaseConnection.getConnection().commit();
			dbUnitDatabaseConnection.close();
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
			dbUnitDatabaseConnection.getConnection().rollback();
			throw new DatabaseUnitException(e);
		}
		
		LOG.info("Dataset inserted or updated.");

	}

	// METODOS PRIVADOS

	// GETS E SETS
}
