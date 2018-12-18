## Latex

A document preparation system. Latex typesets documents.

## [Overleaf documentation](https://www.overleaf.com/learn/latex/Main_Page)

Overleaf is a free browser based Latex compiler.

### [Overleaft 30 minute tutorial](https://www.overleaf.com/learn/latex/Learn_LaTeX_in_30_minutes) 

Latex files end with an .tax extension.  
Latex files have a preamble and a body.  
Latex files can display images, tables, equations, hyperlinks and much more by importing a package.  


```latex
% preamble: before the document body

\documentclass[12pt, a4paper]{article} % declare a type of document (article, book, report, ...)
                                           % parameters are in []; example: font size and paper size [12pt, letterpaper]
\usepackage[utf8]{inputenc} % suggested encoding



\usepackage{amsmath} % math package (display mode equations)
\usepackage{hyperref} % hyperlink package

\usepackage{graphicx} % image package
\graphicspath{ {images/} } % image package is told to look for pictures in folder "this_folder/images"



\title{First document} % part of almost every document
\author{Hubert Farnsworth}
\thanks{Thanks!}
\date{February 2014} % use the command "\today" to use the compile time date



\begin{document} % begin document body



\maketitle % make the preamble elements appear (title, author and date)



\textbf{Bold}
\underline{Underlined} 
\textit{Italic}
\textbf{\textit{Bold and Italic}}

{\tiny tiny text}
{\LARGE large text}




\begin{figure}[h] % figure (picture) construct
    \centering
    \includegraphics[width=0.25\textwidth]{mozilla_logo} % display picture called "mozilla_logo" if it can be located by graphicx package
    \caption{text below the picture}
    \label{fig:picture_label}
\end{figure}
 
Picture number reference: \ref{fig:picture_label}
Picture page reference: \pageref{fig:picture_label} 



\begin{itemize}
  \item Bullet point one in an unordered list
  \item Bullet point two
\end{itemize}

\begin{enumerate}
  \item First item in an ordered list
  \item Second item
\end{enumerate}



Inline equation $E=mc^2$ stats and ends with a dollar sign.

\begin{equation} % display mode equation using amsmath package
E=mc^2
\end{equation}

Complex amsmath package equation:
$$T^{i_1 i_2 \dots i_p}_{j_1 j_2 \dots j_q} = T(x^{i_1},\dots,x^{i_p},e_{j_1},\dots,e_{j_q})$$

$$\int_0^1 \frac{1}{e^x} =  \frac{e-1}{e}$$

$\sin(\beta)$, $\cos(\alpha)$, $\log(x)$



\begin{abstract}
Special abstract formatting. Monstly at the beginning of the paper.
\end{abstract}



Double newline to create a new paragraph.
Double backslash or newline command to insert a breakpoint. Not recommended.



\tableofcontents % create table of contents based on section, subsection and chapter commands
                 % add others manually with \addcontentsline

\section{Numbered section (1.1 for example)}
 
Text.
 
\section{Another numbered section (1.2 for example)}

Text.
 
\subsection{Numbered subsection (1.2.1 for example)}

Text.

\addcontentsline{toc}{section}{Unnumbered Section} % add to ToC (Table of Contents) a section called "Unnumbered Section"
\section*{Unnumbered Section} % * disables numbering

There are a lot more "section"-like commands.



Latex table generator: https://www.tablesgenerator.com/

\begin{center}

\begin{table}
\centering

\begin{tabular}{ |l|c|r| } % left, center and right aligned columns, | separated by a vertical line
 cell1 & cell2 & cell3 \\ % & to break table entry, \\ to go to the next table line
 cell4 & cell5 & cell6 \\  
 cell7 & cell8 & cell9   
/hline                    % add horitontal line to the bottom of the table 
\end{tabular}

\caption{text below table}
\label{table:table_label}
\end{table}

\end{center}



\end{document}
```

### [Advanced: sections and chapters](https://www.overleaf.com/learn/latex/Sections_and_chapters)

```latex
\documentclass[a4paper,12pt]{article}
\usepackage[utf8]{inputenc}
\usepackage{titlesec} % customiseable sections package
 
 
 
\titleformat{\section} % command: customise "\section" command
[display] % shape: possible values are: hang, block, display, runin, leftmargin, rightmargin, drop, wrap, frame
{\large\scshape\raggedright} % format: large header, small capital letters, left aligned
{} % label
{0em} % sep: horizontal separation of label and title body
{} % before-code: code to be executed before title body
[\titlerule] % after-code: code to be executed after title body; create horizontal line

\titlespacing{\section} % command: customise "\section" command
{1pc} % left: increases left margin
{} % before-sep: vertical space before the title
{} % after-sep: separation between title and non-sectioning text



\begin{document}
 
\chapter{Let's begin}
 
\section{First Attempt}
 
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do 
eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut 
enim ad minim veniam, quis nostrud exercitation ullamco laboris...
 
\section{Second attempt}
 
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do 
eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut 
enim ad minim veniam, quis nostrud exercitation ullamco laboris...
 
\end{document}
```

### [Advanced: page size and margins](https://www.overleaf.com/learn/latex/Page_size_and_margins)

```latex
\documentclass[a4paper]{article}
\usepackage[utf8]{inputenc}

\usepackage{geometry}

\geometry{
total={170mm,257mm},
left=20mm,
top=20mm,
}
 
\begin{document}

Example with user-defined dimensions

\end{document}
```

### [Advanced: custom commands](https://www.overleaf.com/learn/latex/Commands)

```latex
\documentclass[a4paper]{article}
\usepackage[utf8]{inputenc}
\usepackage{amssymb}

\newcommand{\plusbinomial} % new command name is "\plusbinomial"
[3] % number of parameters
[2] % default value for the first parameter
{(#2 + #3)^#1} % # use passed parameters and execute the new command

\renewcommand{\S}{\mathbb{S}} % override an existing command "\S"
 
\begin{document}

Example with user-defined dimensions

\end{document}
```

### [Advanced: hyperlinks](https://www.overleaf.com/learn/latex/Hyperlinks#PDF-specific_options)

```latex
\documentclass{book}
\usepackage[utf8]{inputenc}

\usepackage{hyperref} % make sure it is always the last imported package

\hypersetup{
colorlinks=true,
linkcolor=blue,
filecolor=magenta,      
urlcolor=cyan,
pdftitle={Sharelatex Example}, % next three are PDF specific
pdfpagemode=FullScreen,
}

\urlstyle{same} % display links like the rest of the text
 
\begin{document}
 
\tableofcontents % will be hyperlinked by default
 
\chapter{First Chapter}
 
Reference: \href{http://www.sharelatex.com}{Something Linky}
URL: \url{http://www.sharelatex.com}
File: \href{run:./file.txt}{File.txt}
 
\end{document}
```

### [Advanced: multiple columns](https://www.overleaf.com/learn/latex/Multiple_columns)


```latex
\documentclass{article}
\usepackage[utf8]{inputenc}
 
\usepackage{multicol}

% it is possible to add vertical rulers
% it is possible to add floating elements like tables and pictures into columns

\begin{document}

\begin{multicols}{3} % number of columns is three
[ % header text, text before the multiple column body
\section{First Section}
All human things are subject to decay. And when fate summons, Monarchs must obey.
]
% multiple column body
Hello, here is some text without a meaning.  This text should show what 
a printed text will look like at this place.
If you read this text, you will get no information.  Really?  Is there 
no information?  Is there...

\end{multicols}
 
\end{document}
```
