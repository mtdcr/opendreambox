all: opendreambox.pdf

%.pdf: %.tex Makefile
	pdflatex $<
	pdflatex $<
	pdflatex $<

%.dvi: %.tex Makefile
	latex $<
	latex $<
	latex $<

HTLATEX_OPTIONS = "html"

%.html: %.tex Makefile
	htlatex $< "${HTLATEX_OPTIONS}"
	htlatex $< "${HTLATEX_OPTIONS}"
	htlatex $< "${HTLATEX_OPTIONS}"

%.txt: %.html
	links -dump -width 85 $< | sed -e 's/\s\+$$//' > $@

clean:
	$(RM) *.{4ct,4tc,aux,dvi,idv,lg,log,out,pdf,tmp,toc,xml,xref}
