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
        ]
    ],
    [
        name: "Python",
        extensions: [
            ".py"
        ]
    ],
    [
        name: "JSON",
        type: "data",
        extensions: [
            ".json"
        ]
    ],
    [
        name: "CoffeeScript",
        extensions: [
            ".coffee"
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
  Regular Expressions Matching Ignored Files
  Most of this is copied from liguist (https://github.com/github/linguist/blob/master/lib/linguist/vendor.yml)
  Due to the use of regex, slashy strings are recommended
  These are used for things like git repositories
*/
ignored_files = [
    /* LICENSE, README, git config files */
    /^COPYING$/,
    /LICENSE$/,
    /License$/,
    /gitattributes$/,
    /gitignore$/,
    /gitmodules$/,
    /^README$/,
    /^readme$/,
    /* Samples */
    /^[Ss]amples\//,
    /* Gradle */
    /(^|\/)gradlew$/,
    /(^|\/)gradle\/wrapper\//,
    /node_modules\//,
    /bower_components\//
]

