PR .= "-dream1"

DEPENDS := "${@oe_filter_out('^(gnome-keyring|libproxy)$', '${DEPENDS}', d)}"

EXTRA_OECONF += "--without-gnome"
