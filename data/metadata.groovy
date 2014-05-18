/*
  Metadata for Langly
*/

/* Language List */
languages = [
    [
        name: "Groovy",
        extensions: [
            ".groovy",
            ".gvy"
        ],
        related: [
            "Java"
        ],
        interpreters: [
            "groovy"    
        ]
    ],
    [
        name: "Java",
        extensions: [
            ".java"
        ]
    ],
    [
        name: "JavaScript",
        extensions: [
            ".js"
        ],
        filenames: [
            "Jakefile"
        ],
        interpreters: [
            "node"
        ]
    ],
    [
        name: "Scala",
        extensions: [
            ".scala"
        ]
    ],
    [
        name: "Ruby",
        extensions: [
            ".rb"
        ],
        filenames: [
            "Rakefile"
        ],
        interpreters: [
            "ruby"    
        ]
    ],
    [
        name: "Python",
        extensions: [
            ".py"
        ],
        interpreters: [
            "python"    
        ]
    ],
    [
        name: "JSON",
        type: "data",
        extensions: [
            ".json"
        ],
        filenames: [
            ".jshintrc"
        ]
    ],
    [
        name: "CoffeeScript",
        extensions: [
            ".coffee"
        ],
        filenames: [
            "Cakefile"
        ]
    ],
    [
        name: "CSON",
        type: "data",
        extensions: [
            ".cson"
        ],
        related: [
            "JSON",
            "CoffeeScript"
        ]
    ],
    [
        name: "C",
        extensions: [
            ".c",
            ".w"
        ]
    ],
    [
        name: "C++",
        extensions: [
            ".cpp",
            ".h",
            ".cxx",
            ".c++"
        ]
    ],
    [
        name: "D",
        extensions: [
            ".d",
            ".di"
        ]
    ],
    [
        name: "HTML",
        type: "markup",
        extensions: [
            ".html",
            ".htm",
            ".xhtml"
        ]
    ],
    [
        name: "Go",
        extensions: [
            ".go"
        ]
    ],
    [
        name: "Shell",
        extensions: [
            ".sh",
            ".bash",
            ".zsh"
        ],
        interpreters: [
            "bash",
            "sh",
            "zsh"
        ],
        filenames: [
            "Dockerfile"    
        ]
    ],
    [
        name: "Erlang",
        extensions: [
            ".erl",
            ".hrl"
        ]
    ],
    [
        name: "ANTLR",
        extensions: [
            ".g4"
        ]
    ],
    [
        name: "Markdown",
        extensions: [
            ".md",
            ".markdown"
        ]
    ],
    [
        name: "C#",
        extensions: [
            ".cs"
        ]
    ],
    [
        name: "CSS",
        extensions: [
            ".css"
        ]
    ],
    [
        name: "Ceylon",
        extensions: [
            ".ceylon"
        ]
    ],
    [
        name: "Less",
        type: "markup",
        extensions: [
            ".less"
        ],
        related: [
            "CSS"
        ]
    ],
    [
        name: "Lua",
        extensions: [
            ".lua",
            ".nse",
            ".rbxs"
        ],
        interpreters: [
            "lua"    
        ]
    ],
    [
        name: "PHP",
        extensions: [
            ".php",
            ".php3",
            ".php4",
            ".php5"
        ],
        filenames: [
            "Phakefile"
        ]
    ],
    [
        name: "Dogescript",
        extensions: [
            ".djs"
        ]
    ],
    [
        name: "Fourth",
        extensions: [
            ".fth",
            ".4th"
        ]
    ],
    [
        name: "JSON5",
        type: "data",
        extensions: [
            ".json5"
        ],
        related: [
            "JSON"
        ]
    ],
    [
        name: "Kotlin",
        extensions: [
            ".kt",
            ".ktm",
            ".kts"
        ]
    ],
    [
        name: "XML",
        type: "markup",
        extensions: [
            ".xml"
        ]
    ],
    [
        name: "YAML",
        extensions: [
            ".yml",
            ".yaml"
        ]
    ],
    [
        name: "Jade",
        type: "markup",
        extensions: [
            ".jade"
        ],
        related: [
            "HTML"
        ]
    ]
]

/* File Extensions that are commonly binary files */
binary_extensions = [
    ".jar",
    ".zip",
    ".gz",
    ".tar",
    ".bz2",
    ".obj",
    ".exe"
]

/*
  Regular Expressions Matching Vendor Files
  No escaping is necessary, as it is auto-quoted.
*/
vendor = [
    'README(.*)',
    '.gitignore',
    '.gitattributes',
    '.gitmodules',
    '(^|/)gradle/wrapper/(.*)'
]
