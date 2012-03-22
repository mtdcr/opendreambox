DEPENDS := "${@oe_filter_out('^(mysql5|postgresql|sqlite)$', '${DEPENDS}', d)}"
PR .= "-dream2"

QT_CONFIG_FLAGS += "-nomake demos -nomake docs -nomake examples"

QT_SQL_DRIVER_FLAGS += "-no-sql-mysql -no-sql-psql -no-sql-sqlite2"
